package com.jieve.course.task;

import com.jieve.course.task.base.CourseCrawler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskApplicationTests {

    @Autowired
    private CourseCrawler crawler;

    @Test
    void contextLoads() {
        crawler.process();
    }

}
