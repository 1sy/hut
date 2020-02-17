package com.sy.mapper;

import com.sy.pojo.BookCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookCategoryMapper {

    Integer getAllCount();

    List<BookCategory> getBookCategoryByPage(@Param("page") Integer page, @Param("limit") Integer limit);
}
