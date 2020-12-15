package com.lei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

 //  路径 /hello/h1
    @RequestMapping("/h1")
    public String hello(Model model) {
        model.addAttribute("msg","Hello springmvc-annotation");
        return "hello";
    }

}
