package com.sy.controller;

import com.sy.mapper.BookCategoryMapper;
import com.sy.mapper.BookInfoMapper;
import com.sy.mapper.UserMapper;
import com.sy.pojo.BookCategory;
import com.sy.pojo.BookInfo;
import com.sy.pojo.User;
import com.sy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    BookCategoryMapper bookCategoryMapper;
    @Autowired
    BookService bookService;
    @Autowired
    BookInfoMapper bookInfoMapper;

    @RequestMapping("/login")
    public String toLogin() {
        return "page/login";
    }


    @RequestMapping("/index")
    public String toIndex(
            @RequestParam(value = "userId", defaultValue = "0") String userId,
            Model model) {
        User user = userMapper.getUserById(Long.parseLong(userId));
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
        model.addAttribute("user", user);
        return "page/user-info";
    }

    @RequestMapping("/bookCategoryManager")
    public String toBookCategoryManager() {
        return "page/book-category";
    }

    @RequestMapping("/bookInfoManager")
    public String toBookInfoManager() {
        return "page/book-info";
    }

    @RequestMapping("/classManager")
    public String toClassManager() {
        return "page/form";
    }

    @RequestMapping("/bookManager")
    public String toBookManager() {
        return "page/form";
    }

    @RequestMapping("/toBookAdd")
    public String toBookAdd(Model model) {
        List<BookCategory> categoryList = bookCategoryMapper.getTypeAndName();
        model.addAttribute("categoryList", categoryList);
        return "page/book-add";
    }

    @GetMapping("/toBookUpdate")
    public String toBookUpdate(@RequestParam("bookId") String bookId, Model model) {  //RequestBody 必须是json  RequestParam 必须是key-value形式
        List<BookCategory> categoryList = bookCategoryMapper.getTypeAndName();
        BookInfo book = bookInfoMapper.getBookById(bookId);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("book", book);
        return "page/book-update";
    }

}
