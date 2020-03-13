package com.sy.controller.MallController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sy.mapper.BookCategoryMapper;
import com.sy.mapper.BookInfoMapper;
import com.sy.pojo.BookCategory;
import com.sy.pojo.BookInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
public class SearchController {
    @Autowired
    private BookCategoryMapper bookCategoryMapper;
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Resource(name = "redisTemplate") //爆红是因为redisTemplate并不是ValueOperations的子类，运行成功是因为spring的工厂模式
    private ValueOperations<String, String> stringValueOperations;


    @RequestMapping("/mall/search")
    public String toShopSearch(@RequestParam(name = "page", defaultValue = "1") Integer page,
                               @RequestParam("bookInfo") String bookInfo,
                               Model model) {
        //查询由于每次都不同 又加了分页 情况太多 所以暂时不放进redis
        String categoryList = stringValueOperations.get("categoryList");
        if (null == categoryList) {
            log.info("mysql查询：categoryList");
            stringValueOperations.set("categoryList", JSON.toJSONString(bookCategoryMapper.getTypeAndName()), 30L, TimeUnit.MINUTES);
            categoryList = stringValueOperations.get("categoryList");
        }
        List<BookInfo> bookList = bookInfoMapper.getBookByPage((page - 1) * 6, 6, "%" + bookInfo + "%");
        model.addAttribute("bookList", bookList);
        model.addAttribute("categoryList", JSONArray.parseArray(categoryList, BookCategory.class));
        model.addAttribute("count", bookInfo.isEmpty() ? bookInfoMapper.getAllCount() : bookInfoMapper.getCountByName("%" + bookInfo + "%"));
        model.addAttribute("bookInfo", bookInfo);
        model.addAttribute("page", page);
        model.addAttribute("type", 0);
        return "mallPage/commodity";
    }

    @RequestMapping("/mall/searchByCategory")
    public String searchByCategory(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                   @RequestParam("categoryType") Integer categoryType,
                                   Model model) {
        List<BookInfo> bookList = bookInfoMapper.getBookByCategory((page - 1) * 6, 6, categoryType);
        String categoryList = stringValueOperations.get("categoryList");
        if (null == categoryList) {
            log.info("mysql查询：categoryList");
            stringValueOperations.set("categoryList", JSON.toJSONString(bookCategoryMapper.getTypeAndName()), 30L, TimeUnit.MINUTES);
            categoryList = stringValueOperations.get("categoryList");
        }
        model.addAttribute("bookList", bookList);
        model.addAttribute("categoryList", JSONArray.parseArray(categoryList, BookCategory.class));
        model.addAttribute("count", bookInfoMapper.getCountByCategory(categoryType));
        model.addAttribute("categoryType", categoryType);
        model.addAttribute("page", page);
        model.addAttribute("type", 1);
        return "mallPage/commodity";
    }

}
