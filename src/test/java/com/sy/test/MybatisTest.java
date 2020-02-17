package com.sy.test;

import com.sy.mapper.UserMapper;
import com.sy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MybatisTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
//        String pwd = userMapper.getPwdByUsername("qwe");
//        System.out.println(pwd);
        List<User> list = userMapper.getAll();
        for (User user : list) {
            System.out.println(user.toString());
        }
    }
}
