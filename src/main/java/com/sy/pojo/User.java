package com.sy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long userId;
    private String userPassword;
    private String userName;
    private String userImg;
    private String userEmail;
    private Date userRegeistTime;
    private BigDecimal userBalance;
    private int userLevel;


}
