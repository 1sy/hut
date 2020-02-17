package com.sy.test;


import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

public class MD5Test {
    @Test
    public void test() {

        System.out.println(DigestUtils.md5DigestAsHex(new byte[]{1, 2, 2}));
    }

}
