package com.jieve.course.task.tasks;

import com.google.common.collect.Lists;
import com.jieve.course.common.beans.EnrollmentMajorData;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Jieve
 */
@Service
public class ShandongUniversityTask extends AbstractTask<EnrollmentMajorData> {

    @Override
    public Collection<EnrollmentMajorData> findData() {
        return Lists.newArrayList(new EnrollmentMajorData());
    }

    @Override
    public void processData(Collection<EnrollmentMajorData> data) {
        System.out.println(data);

    }

    @Override
    public void filterData(Collection<EnrollmentMajorData> data) {
        //do nothing
    }
}
