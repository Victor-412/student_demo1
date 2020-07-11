package com.victor.controller;

import com.victor.pojo.User;
import com.victor.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "password",required = false) String password,
                        HttpSession session, Model model){
        User user = userService.login(username, password);
        if (user != null){
            //登陆成功
            session.setAttribute("username",user.getUserName());
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }
    @GetMapping("/user/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();;
        return "redirect:/index.html";
    }

}
