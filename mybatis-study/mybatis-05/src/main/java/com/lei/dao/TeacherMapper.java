package com.lei.dao;

import com.lei.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
   @Select("select * from teacher where id=#{id}")
    Teacher getTeacher(int id);
}
