package com.lei.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lei.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {



    @RequestMapping("/j1")
    @ResponseBody  //就不会走视图解析器，直接返回一个字符串
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<User>();
        User user1 = new User("你好",12,"男");
        User user2 = new User("你好",12,"男");
        User user3 = new User("你好",12,"男");
        User user4 = new User("你好",12,"男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        //String s1 = mapper.writeValueAsString(list);
        //String s = JSON.toJSONString(list);

        //Java对象转json字符串
        String s = JSON.toJSONString(user1);
        //json字符串转java对象
        User user = JSON.parseObject(s, User.class);
        //Java对象转json对象
        JSONObject jsonObject = (JSONObject)JSON.toJSON(user1);
        //json对象转Java对象
        User user5 = JSON.toJavaObject(jsonObject, User.class);


        return s;
    }
}
