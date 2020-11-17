package com.lei.demo.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  //等价于<bean id="user" class="com.lei.demo.dao.User"/>
@Scope("singleton")
public class User {
    @Value("你好") //相当于<property name="name" value="你好"/>
    public String name ;
}
