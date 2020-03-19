package com.sy.controller.MallController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sy.mapper.BookInfoMapper;
import com.sy.mapper.ShoppingCartMapper;
import com.sy.pojo.BookInfo;
import com.sy.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
public class MallPageController {
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Resource(name = "redisTemplate") //爆红是因为redisTemplate并不是ValueOperations的子类，运行成功是因为spring的工厂模式
    private ValueOperations<String, String> stringValueOperations;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;


    @RequestMapping("/mall")
    public String toShopMain(Model model) {
        String newBook = stringValueOperations.get("newBookList");
        String salesMax = stringValueOperations.get("salesMaxList");
        String stockMax = stringValueOperations.get("stockMaxList");
        if (null == newBook) {
            log.info("mysql查询：newBookList");
            stringValueOperations.set("newBookList", JSON.toJSONString(bookInfoMapper.getNewBook()), 30L, TimeUnit.MINUTES);
            newBook = stringValueOperations.get("newBookList");
        }
        if (null == salesMax) {
            log.info("mysql查询：salesMaxList");
            stringValueOperations.set("salesMaxList", JSON.toJSONString(bookInfoMapper.getSalesMax()), 30L, TimeUnit.MINUTES);
            salesMax = stringValueOperations.get("salesMaxList");
        }
        if (null == stockMax) {
            log.info("mysql查询：stockMaxList");
            stringValueOperations.set("stockMaxList", JSON.toJSONString(bookInfoMapper.getStockMax()), 30L, TimeUnit.MINUTES);
            stockMax = stringValueOperations.get("stockMaxList");
        }
        List<BookInfo> newBookList = JSONArray.parseArray(newBook, BookInfo.class);
        List<BookInfo> salesMaxBookList = JSONArray.parseArray(salesMax, BookInfo.class);
        List<BookInfo> stockMaxList = JSONArray.parseArray(stockMax, BookInfo.class);
        model.addAttribute("newBookList", newBookList);
        model.addAttribute("salesMaxList", salesMaxBookList);
        model.addAttribute("stockMaxList", stockMaxList);
        return "mallPage/shopMain";
    }

    @PostMapping("/mall/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("userPassword") String userPassword,
                        Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        try {
            subject.login(token);
            //授权成功将 user放入session
            Session session = subject.getSession();
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "redirect:/mall";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "username error");
            return "mallPage/shopLogin";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "password error");
            return "mallPage/shopLogin";
        }
    }

    @RequestMapping("/mall/Details")
    public String toDetails(@RequestParam("bookId") String bookId,
                            Model model) {
        BookInfo book = (BookInfo) redisTemplate.opsForHash().get("book", bookId);
        if (null == book) {
            book = bookInfoMapper.getBookById(bookId);
            log.info("从mysql查询教材详情,ID：" + bookId);
            redisTemplate.opsForHash().put("book", bookId, book);
            //hash问题是只能对所有book加时间  不能针对hk操作
            redisTemplate.expire("book", 10L, TimeUnit.MINUTES);
        }
        model.addAttribute("book", book);
        return "mallPage/details";
    }

    @RequestMapping("/mall/toLogin")
    public String toLogin() {
        return "mallPage/shopLogin";
    }





}
