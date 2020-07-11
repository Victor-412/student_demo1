package com.victor.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.victor.dto.studentDTO;
import com.victor.pojo.Department;
import com.victor.pojo.Student;
import com.victor.service.DepartmentService;
import com.victor.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService departmentService;
    //查询所有员工 返回列表页面
    @GetMapping("/student")
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
            List<studentDTO> students = studentService.selectAllStudentDTO();
            System.out.println("分页数据："+students);
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<studentDTO> pageInfo = new PageInfo<studentDTO>(students,pageSize);
            //4.使用model传参数回前端
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("stus",students);
        }finally {
            //清理 ThreadLocal 存储的分页参数,保证线程安全
            PageHelper.clearPage();
        }
        return "student/list.html";
    }

    //to学生添加页面
    @GetMapping("/toAdd")
    public String toAdd(Model model){
        //查出所有的院系，提供选择
        List<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);

        return "student/add.html";
    }
    //学生添加功能，使用Post
    @PostMapping("/add")
    public String add(Student student){
        //保存学生信息
        studentService.addStudent(student);
        //回到学生列表页面
        return "redirect:/student";
    }
    //to员工修改页面
    @GetMapping("/student/{id}")
    public String toUpdateStu(@PathVariable("id") Integer id, Model model){
        //根据id查出来学生
        Student student = studentService.selectById(id);
        //将学生信息返回页面 model.addAttribute("emp",employee);
        model.addAttribute("stu",student);
        //查出所有的部门，提供修改选择
        Collection<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);
        return "student/update.html";
    }

    @PostMapping("/update")
    public String update(Student student){
        studentService.updateStudent(student);
        //回到学生信息列表页面
        return "redirect:/student";
    }
    @GetMapping("/delStu/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        //根据id删除学生 employeeService.deleteEmployee(id);
        studentService.deleteStudent(id);
        return "redirect:/student";
    }


}

