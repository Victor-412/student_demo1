package com.victor.service;

import com.victor.dto.studentDTO;
import com.victor.mapper.StudentMapper;
import com.victor.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<studentDTO> selectAllStudentDTO() {
        return studentMapper.selectAllStudentDTO();
    }
    @Override
    public Student selectById(Integer id) {

        return studentMapper.selectById(id);
    }
    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }
    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
    @Override
    public int deleteStudent(Integer id) {

        return studentMapper.deleteStudent(id);
    }
}
