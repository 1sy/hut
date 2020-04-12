package com.sy.mapper;

import com.sy.pojo.BookInfo;
import com.sy.pojo.dto.OrderCheckDTO;
import com.sy.pojo.vo.OrderBookVO;
import com.sy.pojo.vo.ShoppingItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface BookInfoMapper {

    List<BookInfo> getNewBook();

    List<BookInfo> getSalesMax();

    List<BookInfo> getStockMax();

    List<BookInfo> getBookByPage(@Param("page") Integer page, @Param("limit") Integer limit, @Param("bookName") String bookName);

    Integer getAllCount();

    Integer getCountByName(@Param("bookName") String bookName);

    //很长 没得办法 目前还没想到很简明 的方法
    Integer addBook(@Param("bookId") String bookId, @Param("bookImg") String bookImg, @Param("bookName") String bookName, @Param("bookPrice") BigDecimal bookPrice,
                    @Param("bookStock") Integer bookStock, @Param("bookAuthor") String bookAuthor, @Param("bookPress") String bookPress, @Param("bookIntroduce") String bookIntroduce,
                    @Param("bookStatus") Integer bookStatus, @Param("categoryType") Integer categoryType);

    Integer changeBookStatus(@Param("bookId") String bookId, @Param("bookStatus") Integer bookStatus);


    Integer multipleDelete(@Param("deleteList") List<String> deleteList);

    BookInfo getBookById(@Param("bookId") String bookId);

    ShoppingItemVO getShoppingItemVOById(@Param("bookId") String bookId);

    OrderCheckDTO getOrderCheckDTOById(@Param("bookId") String bookId);

    Integer updateBook(@Param("bookId") String bookId, @Param("bookImg") String bookImg, @Param("bookName") String bookName, @Param("bookPrice") BigDecimal bookPrice,
                       @Param("bookStock") Integer bookStock, @Param("bookAuthor") String bookAuthor, @Param("bookPress") String bookPress, @Param("bookIntroduce") String bookIntroduce,
                       @Param("bookStatus") Integer bookStatus, @Param("categoryType") Integer categoryType);

    Integer deleteBookById(@Param("bookId") String bookId);

    Integer updateBookNoImg(@Param("bookId") String bookId, @Param("bookName") String bookName, @Param("bookPrice") BigDecimal bookPrice,
                            @Param("bookStock") Integer bookStock, @Param("bookAuthor") String bookAuthor, @Param("bookPress") String bookPress, @Param("bookIntroduce") String bookIntroduce,
                            @Param("bookStatus") Integer bookStatus, @Param("categoryType") Integer categoryType);

    List<BookInfo> getBookByInfo(String bookInfo);

    List<BookInfo> getBookByCategory(@Param("page") Integer page, @Param("limit") Integer limit, @Param("categoryType") Integer categoryType);

    Integer getCountByCategory(@Param("categoryType") Integer categoryType);

    Integer getBookStock(@Param("bookId") String bookId);


    Integer updateBookStock(@Param("bookId") String bookId, @Param("bookStock") Integer bookStock);

    OrderBookVO getOrderBookVOByBookId(@Param("bookId") String bookId);

    Integer getTotalCount();
}
