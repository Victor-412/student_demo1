package com.victor.service;

import com.victor.dto.stuCourseDTO;
import com.victor.mapper.StuCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuCourseServiceImpl implements StuCourseService{

    @Autowired
    private StuCourseMapper stuCourseMapper;

    @Override
    public List<stuCourseDTO> selectAllStuCourseDTO() {
        return stuCourseMapper.selectAllStuCourseDTO();
    }

    @Override
    public stuCourseDTO searchByNum(String num) {
        return stuCourseMapper.searchByNum(num);
    }

}
