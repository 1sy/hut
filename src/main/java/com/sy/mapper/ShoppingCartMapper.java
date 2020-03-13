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
}
