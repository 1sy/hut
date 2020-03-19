package com.sy.mapper;

import com.sy.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShoppingCartMapper {
    List<ShoppingCart> getShoppingCartById(@Param("userId") Long userId);

    Integer deleteShoppingCartItem(@Param("userId") Long userId, @Param("bookId") String bookId);

    Integer multipleDelete(@Param("userId") Long userId, @Param("bookIdList") List<String> bookIdList);

    Integer addShoppingCartItem(@Param("userId") Long userId, @Param("bookId") String bookId, @Param("buyNumber") Integer buyNumber);

    Integer updateShoppingCartItem(@Param("userId") Long userId, @Param("bookId") String bookId, @Param("buyNumber") Integer buyNumber);

    Integer getBuyNumberById(@Param("userId") Long userId, @Param("bookId") String bookId);

    Integer getShoppingCartItemCountById(@Param("userId") Long userId);
}
