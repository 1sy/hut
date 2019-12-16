package com.sy.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/login")
    public String toLogin() {
        return "page/login";
    }


    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/main")
    public String toMain() {
        return "page/welcome-1";
    }

    @RequestMapping("/userInfo")
    public String toUserInfo() {
        return "/page/user-setting";
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
