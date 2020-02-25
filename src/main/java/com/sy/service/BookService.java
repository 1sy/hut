package com.sy.service;

import com.sy.mapper.BookCategoryMapper;
import com.sy.mapper.BookInfoMapper;
import com.sy.pojo.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    BookCategoryMapper bookCategoryMapper;

    //将类目表中，categoryType和categoryName 封装成Map 之后通过get取值，更加方便
    public Map<Integer, String> getBookCategoryMap() {
        List<BookCategory> typeAndNameList = bookCategoryMapper.getTypeAndName();
        Map<Integer, String> bookCategoryMap = new HashMap<>();
        for (BookCategory bookCategory : typeAndNameList) {
            bookCategoryMap.put(bookCategory.getCategoryType(), bookCategory.getCategoryName());
        }
        return bookCategoryMap;
    }

}
