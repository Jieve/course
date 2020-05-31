package com.jieve.course.task.base;

import com.jieve.course.task.tasks.AbstractTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.util.Optional.ofNullable;

/**
 * @author Jieve
 */
@Service
public class CourseCrawler {

    @Autowired
    private Collection<AbstractTask> list;

    public void process() {
        ofNullable(list).ifPresent(value -> {
            value.forEach(e -> {
                System.out.println("111");
                e.process();
            });
        });
    }
}
