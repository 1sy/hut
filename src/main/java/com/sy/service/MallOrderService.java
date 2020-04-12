package com.sy.service;

import com.alibaba.fastjson.JSONArray;
import com.sy.mapper.BookInfoMapper;
import com.sy.mapper.OrderMapper;
import com.sy.mapper.ShoppingCartMapper;
import com.sy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class MallOrderService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    BookInfoMapper bookInfoMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    ShoppingCartMapper shoppingCartMapper;


    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public void toAddOrder(String orderId,
                           Long userId,
                           BigDecimal orderAmount,
                           String list,
                           String addresseeName,
                           String addresseeTelephone,
                           String addresseeAddress,
                           String bookList) {
        //订单表
        userMapper.payOrder(userId, userMapper.getUserBalance(userId).subtract(orderAmount));
        orderMapper.addOrder(orderId, userId, orderAmount, 0);
        //订单项表
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
        //订单地址
        orderMapper.addOrderAddress(orderId, addresseeName, addresseeTelephone, addresseeAddress);
        //删除购物车项
        if (!list.isEmpty()) {
            List<String> bookIdList = JSONArray.parseArray(bookList, String.class);
            shoppingCartMapper.multipleDelete(userId, bookIdList);
        }
    }

}
