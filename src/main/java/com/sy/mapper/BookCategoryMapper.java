package com.sy.mapper;

import com.sy.pojo.BookCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookCategoryMapper {
    //目前还没有体会到 包装类计算时的问题   之后遇到后要记录
    Integer getAllCount();

    Integer getCountById(@Param("categoryId") String categoryId);

    List<BookCategory> getBookCategoryByPage(@Param("page") Integer page, @Param("limit") Integer limit, @Param("categoryId") String categoryId);


    Integer addBookCategory(@Param("categoryType") Integer categoryType, @Param("categoryName") String categoryName);

    BookCategory checkCategoryType(@Param("categoryType") Integer categoryType);

    BookCategory checkCategoryName(@Param("categoryName") String categoryName);
}
