package com.victor.pojo;

import lombok.Data;

@Data
public class Course {
    private Integer courseId;
    private String courseName;
    private Integer credit;
    private Integer departmentId;
    private String teacher;
}
