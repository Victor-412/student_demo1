package com.victor.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.victor.dto.stuCourseDTO;
import com.victor.dto.studentDTO;
import com.victor.pojo.Department;
import com.victor.pojo.Student;
import com.victor.service.StuCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
public class StcController {

    @Autowired
    private StuCourseService stuCourseService;

    @GetMapping("/search")
    public String search(String num, Model model){
        stuCourseDTO stuCourse = stuCourseService.searchByNum(num);
        model.addAttribute("sts",stuCourse);
        return "stuCourse/search.html";
    }

    @GetMapping("/stuCourse")
    public String list(Model model,
                       @RequestParam(value="pageNum",required = false,defaultValue="1")Integer pageNum,
                       @RequestParam(value="pageSize",defaultValue="10")Integer pageSize){//model是模板，将数据放在里面
        //为了程序的严谨性，判断非空：
        //设置默认当前页
        if(pageNum==null || pageNum<=0){
            pageNum = 1;
        }
        //设置默认每页显示的数据数
        if(pageSize == null){
            pageSize = 10;
        }
        System.out.println("当前页是："+pageNum+"显示条数是："+pageSize);
        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try {
            List<stuCourseDTO> stuCourseDTOS = stuCourseService.selectAllStuCourseDTO();
            System.out.println("分页数据："+stuCourseDTOS);
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<stuCourseDTO> pageInfo = new PageInfo<stuCourseDTO>(stuCourseDTOS,pageSize);
            //4.使用model传参数回前端
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("stcs",stuCourseDTOS);
        }finally {
            //清理 ThreadLocal 存储的分页参数,保证线程安全
            PageHelper.clearPage();
        }
        return "stuCourse/stclist.html";
    }

}
