package com.jieve.course.common;

import com.jieve.course.common.utils.HttpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommonApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(HttpUtils.get("https://www.bkzs.sdu.edu.cn/info/1268/1637.htm"));
    }

}
