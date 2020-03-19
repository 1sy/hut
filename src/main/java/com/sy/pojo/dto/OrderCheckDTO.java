package com.sy.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCheckDTO {
    private String bookId;
    private String bookName;
    private BigDecimal bookPrice;
    private Integer buyNumber;
}
