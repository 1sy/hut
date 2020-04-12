package com.sy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoVO {
    private String orderId;
    private Long userId;
    private BigDecimal orderAmount;
    //DATE_FORMAT 之后  用别名加 字符串类型接收
    private String createTime;
}