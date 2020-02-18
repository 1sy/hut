package com.sy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class HutApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
    }

    @Test
    void test() {
        String a="";
        System.out.println(a == null);
        System.out.println(a.isEmpty());
        System.out.println(a.equals(""));
    }
}
