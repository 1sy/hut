package com.sy.controller;

import com.sy.mapper.UserMapper;
import com.sy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login")
    public String toLogin() {
        return "page/login";
    }


    @RequestMapping("/index")
    public String toIndex(
            @RequestParam(value = "userId", defaultValue = "0") String userId,
            Model model) {
        User user = userMapper.getUserById(Long.parseLong(userId));
        System.out.println(user);
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/main")
    public String toMain() {
        return "page/welcome-1";
    }

    @RequestMapping("/userInfo")
    public String toUserInfo(
            @RequestParam(value = "userId", defaultValue = "0") String userId,
            Model model) {
        User user = userMapper.getUserById(Long.parseLong(userId));
        System.out.println(user);
        model.addAttribute("user", user);
        return "/page/user-info";
    }

    @RequestMapping("/bookCategoryManager")
    public String toBookCategoryManager() {
        return "/page/book-category";
    }


    @RequestMapping("/classManager")
    public String toClassManager() {
        return "/page/form";
    }

    @RequestMapping("/bookManager")
    public String toBookManager() {
        return "/page/form";
    }

}
