package com.lei.dao;

import com.lei.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();
    User getUserById(int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
