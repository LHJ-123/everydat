package com.lei.dao;

import com.lei.pojo.User;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserDao {

    @Select("select * from user")
List<User> getUsers();

    //@Param 如果参数有多个，需要直接获取的话需要加这个注解
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id")int id,@Param("name")String name);

    @Insert("insert into user values(#{id},#{name},#{password}")
    int addUser(User user);

    @Update("update user set name=#{name} , pwd=#{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);

}
