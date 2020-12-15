package com.lei.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //ModeLAndView模型和视图
        ModelAndView mv = new ModelAndView() ;
        //封装对象，放在ModeLAndView中。ModeL
        mv.addObject(  "msg" , "HelloSpringMVC!");
        //封装要跳转的视图，放ModeLAndView中
        mv.setViewName("test"); //WEB-INF/jsp/hello.jsp
        return mv;

    }
}
