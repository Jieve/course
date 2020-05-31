package com.jieve.course.task.tasks;

import java.util.Collection;

public abstract class AbstractTask<T> {

    /**
     * 抓取数据
     * @return
     */
    public abstract Collection<T> findData();

    /**
     * 处理数据
     * @param data
     */
    public abstract void processData(Collection<T> data);

    public void process() {

        Collection<T> data = findData();
        filterData(data);
        processData(data);

    }

    /**
     * 过滤数据
     * @param data
     * @return
     */
    public abstract void filterData(Collection<T> data);
}
