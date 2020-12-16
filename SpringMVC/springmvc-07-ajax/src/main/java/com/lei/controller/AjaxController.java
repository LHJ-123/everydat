package com.lei.controller;


import com.lei.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController//自动返回一个字符串
public class AjaxController {

@RequestMapping("/t1")
    public String test() {
    return "hello";
    }


    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
    if ("lei".equals(name)) {
        response.getWriter().print("true");
    }else {
        response.getWriter().print("false");
    }

    }

    @RequestMapping("/a2")
    public List<User> a2() {
        ArrayList<User> user = new ArrayList<User>();
        user.add(new User("l",12,"男"));
        user.add(new User("h",13,"男"));
        user.add(new User("j",14,"男"));
        return user;
    }

    @RequestMapping("/a3")
   public String a3(String name,String pwd) {
    String msg = "";
    if (name != null) {
        if ("admin".equals(name)) {
            msg = "ok";
        }else {
            msg = "用户名已存在";
        }
    }
        if (pwd != null) {
            if ("123456".equals(pwd)) {
                msg = "ok";
            }else {
                msg = "密码错误";
            }
        }
        return msg;
   }
}
