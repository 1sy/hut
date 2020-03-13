package com.sy.mapper;

import com.sy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> getAll();

    User getUserByUsername(@Param("userName") String userName);

    User getUserById(@Param("userId") Long userId);

    int updateUserInfo(@Param("userId") Long userId, @Param("userEmail") String userEmail, @Param("userImg") String userImg);
}
