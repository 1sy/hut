package com.sy.test;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class LogTest {

    @Test
    public void test1() {
        String name = "asd";
        String pwd = "qwe";
        log.info("name: {},pwd: {}", name, pwd);

        log.info("info....");
    }

    @Test
    public void test2() {
        // D:\idea\IDEA-Projects\hut\src\main\resources\static\images
        System.out.println(System.getProperty("user.dir").toString() + "\\src\\main\\resources\\static\\images");
    }

}
