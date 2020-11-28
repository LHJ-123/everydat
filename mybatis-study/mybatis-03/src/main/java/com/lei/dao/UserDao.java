package com.lei.dao;

import com.lei.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    User getUserById(int id);
    List<User> getUserByLimit(Map<String,Integer> map);

}
