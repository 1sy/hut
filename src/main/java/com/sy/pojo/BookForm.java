package com.sy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {  //用于接收教材表单数据，不然在controller写很多参数不太好看
    private String bookId;
    private MultipartFile bookImg;
    private String bookName;
    private BigDecimal bookPrice;
    private Integer bookStock;
    private String bookAuthor;
    private String bookPress;
    private String bookIntroduce;
    private String bookStatus;
    private Integer categoryType;
}
