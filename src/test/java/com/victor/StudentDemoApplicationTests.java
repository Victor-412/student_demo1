package com.victor;

import com.victor.dto.studentDTO;
import com.victor.pojo.Department;
import com.victor.pojo.Student;
import com.victor.pojo.User;
import com.victor.service.DepartmentService;
import com.victor.service.StudentService;
import com.victor.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class StudentDemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());
        connection.close();
    }
    //用户登录测试
    @Autowired
    private UserService userService;
    @Test
    public void login() {
        User admin = userService.login("admin", "123456");
        System.out.println(admin);
    }
    //院系显示测试
    @Autowired
    private DepartmentService departmentService;
    @Test
    public void selectAllDepartment() {
        List<Department> departments = departmentService.selectAllDepartment();
        for (Department i : departments){
            System.out.println(i);
        }
    }
    //学生信息模块测试
    @Autowired
    private StudentService studentService;
    @Test
    public void selectAllStudentDTO(){
        List<studentDTO> studentDTOS = studentService.selectAllStudentDTO();
        for (studentDTO m : studentDTOS){
            System.out.println(m);
        }
    }
    @Test
    public void selectById(){
        Student student = studentService.selectById(1);
        System.out.println(student);
    }
    @Test
    public void addStudent(){
        Student student = new Student();
        student.setId(9);
        student.setStudentName("果粒");
        student.setNum("15112345670");
        student.setGender(0);
        student.setDepartmentId(5);
        student.setMajor("计算机");
        studentService.addStudent(student);
        Student student1 = studentService.selectById(9);
        System.out.println(student1);
    }
    @Test
    public void updateStudent(){
        Student student = new Student();
        student.setId(1);
        student.setStudentName("张冰");
        student.setNum("15112345570");
        student.setGender(0);
        student.setDepartmentId(5);
        student.setMajor("计算机");
        studentService.updateStudent(student);
        Student student2 = studentService.selectById(1);
        System.out.println(student2);
    }
    @Test
    public void deleteStudent(){
        studentService.deleteStudent(9);
    }
}
