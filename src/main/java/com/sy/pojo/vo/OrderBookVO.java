package com.sy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderBookVO {
    private String bookName;
    private BigDecimal bookPrice;
    private Integer buyNumber;
}
