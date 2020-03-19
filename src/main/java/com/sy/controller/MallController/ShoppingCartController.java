package com.sy.controller.MallController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sy.mapper.BookInfoMapper;
import com.sy.mapper.ShoppingCartMapper;
import com.sy.pojo.ShoppingCart;
import com.sy.pojo.dto.OrderCheckDTO;
import com.sy.pojo.vo.ShoppingCartVO;
import com.sy.pojo.vo.ShoppingItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Resource(name = "redisTemplate") //爆红是因为redisTemplate并不是ValueOperations的子类，运行成功是因为spring的工厂模式
    private ValueOperations<String, String> stringValueOperations;

    //运用单例模式创建购物车
    @ResponseBody
    @RequestMapping("/mall/checkShoppingCart")
    public int checkShoppingCart(@RequestParam("userId") Long userId) {
        return shoppingCartMapper.getShoppingCartById(userId).isEmpty() ? 0 : 1;
    }

    @PostMapping("/mall/toShoppingCart")
    public String toShopCart(@RequestParam("userId") Long userId, Model model) {
        /*这个地方比较乱   1.通过userId查询购物车
                         2.购物车表只存了bookId和buyNumber  再通过bookId查询到要展示的信息，因为每次sql执行过多次，放到redis
        *                3.把shoppingItemVO对象依次存到shoppingCartVO 再绑定到list 传到前端
        * */
        List<ShoppingCart> shoppingCart = shoppingCartMapper.getShoppingCartById(userId);
        List<ShoppingCartVO> shoppingCartVOList = new ArrayList<>();
        for (ShoppingCart s : shoppingCart) {
            String bookId = s.getBookId();
            String shoppingItemVO = stringValueOperations.get("shoppingItemVO:" + bookId);
            if (null == shoppingItemVO) {
                log.info("mysql查询：shoppingItemVO:" + bookId);
                stringValueOperations.set("shoppingItemVO:" + bookId, JSON.toJSONString(bookInfoMapper.getShoppingItemVOById(bookId)), 5L, TimeUnit.MINUTES);
                shoppingItemVO = stringValueOperations.get("shoppingItemVO:" + bookId);
            }
            shoppingCartVOList.add(new ShoppingCartVO(JSONObject.parseObject(shoppingItemVO, ShoppingItemVO.class), s.getBuyNumber()));
        }
        model.addAttribute("shoppingCartVOList", shoppingCartVOList);
        return "mallPage/shopCart";
    }


    @ResponseBody
    @PostMapping("/mall/toAddShoppingCartItem")
    public Integer toAddShoppingCartItem(@RequestParam("userId") Long userId,
                                         @RequestParam("bookId") String bookId,
                                         @RequestParam("buyNumber") Integer buyNumber) {
        //添加购物车逻辑  当前Id有该书就在原来buyNumber基础上加  没有就首先判断购物车已有数量大于5，没有再新插入一条
        Integer result = shoppingCartMapper.getBuyNumberById(userId, bookId);
        if (result != null) {
            return shoppingCartMapper.updateShoppingCartItem(userId, bookId, result + buyNumber) > 0 ? 1 : 0;
        } else {
            if (shoppingCartMapper.getShoppingCartItemCountById(userId) < 5) {
                return shoppingCartMapper.addShoppingCartItem(userId, bookId, buyNumber) > 0 ? 1 : 0;
            }
            return 5; //代表当前用户已经有五件了  不可以再添加
        }
    }

    @ResponseBody
    @PostMapping("/mall/toDeleteShoppingCartItem")
    public Integer toDeleteShoppingCartItem(@RequestParam("userId") Long userId,
                                            @RequestParam("bookId") String bookId) {
        return shoppingCartMapper.deleteShoppingCartItem(userId, bookId) > 0 ? 1 : 0;
    }

    @ResponseBody
    @PostMapping("/mall/toDeleteOrderItem")
    public Integer toDeleteOrderItem(@RequestParam("userId") Long userId,
                                     @RequestParam("bookIdList") String list) {
        if (list.isEmpty())
            return 1;
        List<String> bookIdList = JSONArray.parseArray(list, String.class);
        return shoppingCartMapper.multipleDelete(userId, bookIdList) >= 0 ? 1 : 0;
    }

    @PostMapping("/mall/toCheckOrder")
    public String checkOrder(@RequestParam("buyList") String list,
                             @RequestParam("totalPrice") String totalPrice,
                             Model model) {

        List<String> buyList = JSONArray.parseArray(list, String.class);
        List<OrderCheckDTO> orderCheckDTOList = new ArrayList<>();
        List<String> bookIdList = new ArrayList<>();
        //        buyList.toString();
        for (String buyItem : buyList) {
            if (buyItem != null) {
                String[] split = buyItem.split("-", 2);
                String bookId = split[0];
                String buyNumber = split[1];
                String orderCheckDTORedis = stringValueOperations.get("orderCheckDTO:" + bookId);
                if (null == orderCheckDTORedis) {
                    log.info("mysql查询：orderCheckDTO:" + bookId);
                    stringValueOperations.set("orderCheckDTO:" + bookId, JSON.toJSONString(bookInfoMapper.getOrderCheckDTOById(bookId)), 15L, TimeUnit.MINUTES);
                    orderCheckDTORedis = stringValueOperations.get("orderCheckDTO:" + bookId);
                }
                OrderCheckDTO orderCheckDTO = JSONObject.parseObject(orderCheckDTORedis, OrderCheckDTO.class);
                orderCheckDTO.setBuyNumber(Integer.parseInt(buyNumber));
                orderCheckDTOList.add(orderCheckDTO);
                bookIdList.add(bookId);
            }
        }
        model.addAttribute("orderCheckDTOList", orderCheckDTOList);
        model.addAttribute("bookIdList", bookIdList);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("buyList", list);
        model.addAttribute("orderId", UUID.randomUUID().toString().replaceAll("-", ""));
        return "mallPage/checkOrder";
    }

    @PostMapping("/mall/toBuyNow")
    public String toBuyNow(@RequestParam("bookId") String bookId,
                           @RequestParam("bookName") String bookName,
                           @RequestParam("bookPrice") BigDecimal bookPrice,
                           @RequestParam("buyNumber") Integer buyNumber,
                           Model model) {
        List<OrderCheckDTO> orderCheckDTOList = new ArrayList<>();
        List<String> bookIdList = new ArrayList<>();
        bookIdList.add(bookId);
        List<String> buyNow = new ArrayList<>();
        buyNow.add(bookId + "-" + buyNumber);
        OrderCheckDTO orderCheckDTO = new OrderCheckDTO(bookId, bookName, bookPrice, buyNumber);
        orderCheckDTOList.add(orderCheckDTO);
        model.addAttribute("orderCheckDTOList", orderCheckDTOList);
        //这里是BigDecimal对金额进行计算
        model.addAttribute("totalPrice", bookPrice.multiply(new BigDecimal(buyNumber.toString())));
        model.addAttribute("orderId", UUID.randomUUID().toString().replaceAll("-", ""));
        model.addAttribute("bookIdList", bookIdList);
        model.addAttribute("buyList", JSON.toJSONString(buyNow));
        return "mallPage/checkOrder";
    }


}
