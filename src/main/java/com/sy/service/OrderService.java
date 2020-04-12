package com.sy.service;

import com.sy.mapper.OrderMapper;
import com.sy.mapper.UserMapper;
import com.sy.pojo.dto.OrderRefundDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public void orderRefund(String orderId) {
        System.out.println(orderId);
        OrderRefundDTO order = orderMapper.getOrderRefundByOrderId(orderId);
        orderMapper.changeOrderStatus(3, orderId);
        userMapper.payOrder(order.getUserId(), userMapper.getUserBalance(order.getUserId()).add(order.getOrderAmount()));
    }

}
