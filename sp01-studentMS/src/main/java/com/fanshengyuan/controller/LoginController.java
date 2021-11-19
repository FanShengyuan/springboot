package com.fanshengyuan.controller;

import com.fanshengyuan.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author fanshengyuan
 * @create 2021-11-15 16:05
 * @description
 */
@Controller
public class LoginController {
    /*
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        //如果用户名和密码正确
        if ("admin".equals(username) && "123456".equals(password)){
            session.setAttribute("LoginUser", username);//用户名传到session，用于安全控制
            return "dashboard";//跳转到dashboard页面

//            return "redirect:/dashboard.html";//重定向到dashboard.html
        }
            //如果用户名或者密码不正确
        else {
            model.addAttribute("msg", "用户名或者密码错误");//显示错误信息
            return "index";//跳转到首页
        }
    }
    */

    @Autowired
    AccountMapper accountMapper;

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        //@RequestParam接收前端数据，参数是前端的name
        if(accountMapper.queryAccountByUsername(username)!=null&& password.equals(accountMapper.queryAccountByUsername(username).getPassword())){
            //查到了用户而且密码正确
            session.setAttribute("LoginUser", username);//用户名传到session，用于安全控制
//            return "dashboard";//跳转到dashboard页面
            return "redirect:/main.html";//重定向到main.html页面,也就是跳转到dashboard页面
        }
        else {
            model.addAttribute("msg", "用户名或者密码错误");//显示错误信息
            return "index";//跳转到首页
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }
}

