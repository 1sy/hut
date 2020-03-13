package com.sy.controller.MallController;

import com.sy.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    //运用单例模式创建购物车
    @ResponseBody
    @RequestMapping("/checkShoppingCart")
    public int checkShoppingCart(@RequestParam("userId") Long userId) {
        return shoppingCartMapper.getShoppingCartById(userId).isEmpty() ? 0 : 1;
    }

}
