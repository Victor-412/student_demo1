package com.victor.mapper;

import com.victor.dto.stuCourseDTO;
import com.victor.dto.studentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StuCourseMapper {

    List<stuCourseDTO> selectAllStuCourseDTO();

    stuCourseDTO searchByNum(String num);

}
