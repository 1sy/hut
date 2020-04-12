package com.sy.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRefundDTO {
    private Long userId;
    private BigDecimal orderAmount;
    private Integer orderStatus;
}
