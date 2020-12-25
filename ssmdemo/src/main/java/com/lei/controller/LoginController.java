package com.lei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String login(String username,String password) {
        String msg = "";
       if (username != null) {
           if ("lhj".equals(username)) {
               msg = "ok";
           }else {
               msg = "用户名不存在";
           }
       }else {
           msg = "请输入用户名";
       }
        if (password != null) {
            if ("123".equals(password)) {
                msg = "ok";
            }else {
                msg = "密码错误";
            }
        }else {
            msg = "请输入密码";
        }
        return msg;

    }

}
