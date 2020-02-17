package com.sy.controller;

import com.alibaba.fastjson.JSONObject;
import com.sy.mapper.BookCategoryMapper;
import com.sy.pojo.BookCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class BookCategoryController {
    @Autowired
    BookCategoryMapper bookCategoryMapper;

    @GetMapping("/getAllBookCategory")
    public String getAllBookCategory(@RequestParam("limit") Integer limit,
                                     @RequestParam("page") Integer page) {
        //layui分页操作  接收传来的limit 和page  直接查询返回即可
        //需要注意 limit  和 page 是默认传过来的，     count 必须是所有数据总数
        log.info("page: {}", page);
        List<BookCategory> list = bookCategoryMapper.getBookCategoryByPage((page - 1) * limit, limit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", bookCategoryMapper.getAllCount());
        jsonObject.put("data", list);
        return jsonObject.toJSONString();
    }

}
