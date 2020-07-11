package com.victor.service;

import com.victor.dto.studentDTO;
import com.victor.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    List<studentDTO> selectAllStudentDTO();

    Student selectById(@Param("id") Integer id);

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(@Param("id") Integer id);
}
