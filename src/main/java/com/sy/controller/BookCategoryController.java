package com.sy.controller;

import com.alibaba.fastjson.JSON;
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


    //合并模糊查询  拼接之后传值 ---- int型并不具备String的模糊性，因为我们往往需要准确的数字，之后选择类型要多考虑
    @GetMapping("/getAllBookCategory")
    public String getAllBookCategory(@RequestParam("limit") Integer limit,
                                     @RequestParam("page") Integer page,
                                     @RequestParam("categoryId") String categoryId) {
        //layui分页操作  接收传来的limit 和page  直接查询返回即可
        //需要注意 limit  和 page 是默认传过来的，     count 必须是所有数据总数
//        log.info("categoryId: {}", categoryId);
        List<BookCategory> list = bookCategoryMapper.getBookCategoryByPage((page - 1) * limit, limit, "%" + categoryId + "%");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        //count主要用于计算总页数， 要区别对待 搜索这一特殊情况  担心每次都like会影响效率，所以设置两个方法来做
        jsonObject.put("count", categoryId.isEmpty() ? bookCategoryMapper.getAllCount() : bookCategoryMapper.getCountById("%" + categoryId + "%"));
        jsonObject.put("data", list);
        return jsonObject.toJSONString();
    }


    @PostMapping("/addBookCategory")
    public String addBookCategory(@RequestParam("bookCategory") String bookCategoryJSON) {
        JSONObject jsonObject = JSON.parseObject(bookCategoryJSON);
        Integer i = bookCategoryMapper.addBookCategory(Integer.parseInt(jsonObject.get("addCategoryType").toString()), jsonObject.get("addCategoryName").toString());
        return i == 1 ? "添加成功" : "添加失败";
    }

    @PostMapping("/checkCategoryType")
    public Integer checkCategoryType(@RequestParam("categoryType") Integer categoryType) {
        BookCategory bookCategory = bookCategoryMapper.checkCategoryType(categoryType);
        return bookCategory != null ? 1 : 0;
    }

    @PostMapping("/checkCategoryName")
    public Integer checkCategoryName(@RequestParam("categoryName") String categoryName) {
        // 之前用对象接受 但是会返回一对多的错误 暂时不知具体为何  之后再做修改
        List<BookCategory> list = bookCategoryMapper.checkCategoryName(categoryName);
        return list.isEmpty() ? 0 : 1;
    }

    @PostMapping("/updateBookCategory")
    public String updateBookCategory(@RequestParam("bookCategory") String bookCategoryJSON) {
        JSONObject jsonObject = JSON.parseObject(bookCategoryJSON);
        Integer i = bookCategoryMapper.updateBookCategory(Integer.parseInt(jsonObject.get("categoryType").toString()), jsonObject.get("categoryName").toString(), Integer.parseInt(jsonObject.get("categoryId").toString()));
        return i == 1 ? "修改成功" : "修改失败";
    }

    @PostMapping("/deleteBookCategory")
    public Integer deleteBookCategory(@RequestParam("categoryId") Integer categoryId) {
        Integer i = bookCategoryMapper.deleteBookCategory(categoryId);
        return i;
    }

}
