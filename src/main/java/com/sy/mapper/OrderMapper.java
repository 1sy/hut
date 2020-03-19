package com.sy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Mapper
@Repository
public interface OrderMapper {

    Integer addOrder(@Param("orderId") String orderId, @Param("userId") Long userId, @Param("orderAmount") BigDecimal orderAmount, @Param("orderStatus") Integer orderStatus);


    Integer addOrderItem(@Param("orderId") String orderId, @Param("bookId") String bookId, @Param("buyNumber") Integer buyNumber);

    Integer addOrderAddress(@Param("orderId") String orderId, @Param("addresseeName") String addresseeName, @Param("addresseeTelephone") String addresseeTelephone, @Param("addresseeAddress") String addresseeAddress);


}


