package com.sy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {
    private String bookId;
    private String bookImg;
    private String bookName;
    private BigDecimal bookPrice;
    private Integer bookStock;
    private String bookAuthor;
    private String bookPress;
    private String bookIntroduce;
    private Integer bookStatus;
    //这样会多加一个字段 但感觉比强转好多了
    private Integer categoryType;
    private String categoryName;

}
