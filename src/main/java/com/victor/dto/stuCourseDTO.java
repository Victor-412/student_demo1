package com.victor.dto;

import lombok.Data;

@Data
public class stuCourseDTO {
    private Integer id;
    private String num;
    private String studentName;
    private String courseName;
    private Integer credit;
    private String teacher;
    private Float score;
}
