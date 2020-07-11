package com.victor.service;

import com.victor.dto.stuCourseDTO;
import com.victor.dto.studentDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuCourseService {

    List<stuCourseDTO> selectAllStuCourseDTO();

    stuCourseDTO searchByNum(String num);

}
