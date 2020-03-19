package com.sy.mapper;

import com.sy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> getAll();

    User getUserByUsername(@Param("userName") String userName);

    User getUserById(@Param("userId") Long userId);

    Integer updateUserInfo(@Param("userId") Long userId, @Param("userEmail") String userEmail, @Param("userImg") String userImg);

    BigDecimal getUserBalance(@Param("userId") Long userId);

    Integer payOrder(@Param("userId") Long userId, @Param("userBalance") BigDecimal userBalance);
}
