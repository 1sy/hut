package com.sy.controller.MallController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mall")
public class MallPageController {

    @RequestMapping({"/toShopMain", ""})
    public String toShopMain() {
        return "/mallPage/shopMain";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/mallPage/login";
    }

    @RequestMapping("/toDetails")
    public String toDetails() {
        return "/mallPage/details";
    }

    @RequestMapping("/toShopCart")
    public String toShopCart() {
        return "/mallPage/shopCart";
    }

}
