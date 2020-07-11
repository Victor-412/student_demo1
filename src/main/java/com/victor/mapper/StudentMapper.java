package com.victor.mapper;

import com.victor.dto.studentDTO;
import com.victor.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    List<studentDTO> selectAllStudentDTO();

    Student selectById(@Param("id") Integer id);

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(@Param("id") Integer id);

}
