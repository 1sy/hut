package com.sy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class User {
    private long userId;
    private String userName;
    private String userPassword;
    private String userImg;
    @Email(message = "必须为邮箱格式")
    private String userEmail;
    private BigDecimal userBalance;
    @Range(min = 0,max = 1,message = "必须为0或1")
    private short userLevel;



}
