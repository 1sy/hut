package com.sy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingItemVO {
    private String bookId;
    private String bookImg;
    private String bookName;
    private String bookAuthor;
    private BigDecimal bookPrice;
    private Integer bookStock;
    private Integer bookStatus;
}
