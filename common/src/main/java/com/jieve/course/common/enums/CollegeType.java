package com.jieve.course.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Jieve
 */
@AllArgsConstructor
public enum CollegeType {

    TYPE_985(1, "985院校"),
    TYPE_211(2, "211院校"),
    TYPE_1_BEN(3, "一类本科院校"),
    TYPE_2_BEN(4, "二类本科院校"),
    TYPE_3_BEN(5, "三类本科院校"),
    TYPE_JUNIOR(6, "专科院校"),
    ;

    private int type;

    private String name;
}
