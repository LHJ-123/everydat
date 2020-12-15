package com.lei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestFulController {
    @RequestMapping("/add/{a}/{b}")
    public String test3(@PathVariable int a,@PathVariable int b, Model model) {
        int res = a+b;
        model.addAttribute("msg","结果为:"+res);
        return "test2";

    }
    @GetMapping("/t1")
    //如果参数传递的是一个对象，会一一匹配对象里的字段名，名字一样则获取到，否则不行
    public String test4(@RequestParam("username") String name, Model model) {
        model.addAttribute("msg",name);
        return "test2";
    }
}
