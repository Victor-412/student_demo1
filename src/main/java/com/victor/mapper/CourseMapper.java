package com.victor.mapper;

import com.victor.pojo.Course;
import com.victor.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {
    List<Course> selectAllCource();

}
