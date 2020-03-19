package com.sy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private Long userId;
    private BigDecimal orderAmount;
    private Integer orderStatus;
}
