package com.sy.controller;

import com.sy.mapper.UserMapper;
import com.sy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/getUser")
    public List<User> getUser() {
        List<User> list = userMapper.getUser();
        for (User user : list) {
            System.out.println(user.toString());
        }
        return list;
    }

}
