package com.sy.controller.MallController;

import com.alibaba.fastjson.JSONArray;
import com.sy.mapper.OrderMapper;
import com.sy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;

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
                String buyNumber = split[1];
                orderMapper.addOrderItem(orderId, bookId, Integer.parseInt(buyNumber));
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
