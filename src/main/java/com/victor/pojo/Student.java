package com.victor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Student {
    private Integer id;
    private String studentName;
    private String num;
    private Integer gender;
    private Integer departmentId;
    private String major;
}
