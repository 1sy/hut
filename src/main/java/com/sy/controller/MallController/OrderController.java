package com.sy.controller.MallController;

import com.alibaba.fastjson.JSONArray;
import com.sy.mapper.BookInfoMapper;
import com.sy.mapper.OrderMapper;
import com.sy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Controller
public class OrderController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    BookInfoMapper bookInfoMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @ResponseBody
    @PostMapping("/mall/toCheckUserBalance")
    public Integer checkUserBalance(@RequestParam("totalPrice") BigDecimal totalPrice,
                                    @RequestParam("userId") Long userId) {
        BigDecimal userBalance = userMapper.getUserBalance(userId);
        return userBalance.compareTo(totalPrice) >= 0 ? 1 : 0;
    }

    @ResponseBody
    @PostMapping("/mall/toAddOrder")
    public Integer toAddOrder(@RequestParam("orderId") String orderId,
                              @RequestParam("userId") Long userId,
                              @RequestParam("orderAmount") BigDecimal orderAmount) {
        userMapper.payOrder(userId, userMapper.getUserBalance(userId).subtract(orderAmount));
        return orderMapper.addOrder(orderId, userId, orderAmount, 0) > 0 ? 1 : 0;
    }

    @ResponseBody
    @PostMapping("/mall/toAddOrderItem")
    public Integer toAddOrderItem(@RequestParam("buyList") String list,
                                  @RequestParam("orderId") String orderId) {
        List<String> buyList = JSONArray.parseArray(list, String.class);
        for (String buyItem : buyList) {
            if (buyItem != null) {
                String[] split = buyItem.split("-", 2);
                String bookId = split[0];
                String buyNumber = split[1];  //这个地方 加入订单项，   改变教材现有库存
                orderMapper.addOrderItem(orderId, bookId, Integer.parseInt(buyNumber));
                Integer bookStock = bookInfoMapper.getBookStock(bookId);
                bookInfoMapper.updateBookStock(bookId, bookStock - Integer.parseInt(buyNumber));
                //修改教材内容后要清下redis缓存
                Set<String> keys = redisTemplate.keys("*" + bookId + "*");
                Set<String> listkeys = redisTemplate.keys("*List");
                redisTemplate.delete(keys);
                redisTemplate.delete(listkeys);
                redisTemplate.opsForHash().delete("book", bookId);
            }
        }
        return 1;
    }


    @ResponseBody
    @PostMapping("/mall/toAddOrderAddress")
    public Integer toAddOrderAddress(@RequestParam("orderId") String orderId,
                                     @RequestParam("addresseeName") String addresseeName,
                                     @RequestParam("addresseeTelephone") String addresseeTelephone,
                                     @RequestParam("addresseeAddress") String addresseeAddress) {
        return orderMapper.addOrderAddress(orderId, addresseeName, addresseeTelephone, addresseeAddress) > 0 ? 1 : 0;
    }

}
