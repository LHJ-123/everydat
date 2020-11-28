package com.lei.dao;

import com.lei.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    //List<Teacher> getTeacher();
    //获取指定老师下所有学生及老师信息
    Teacher getTeacher(int id);
    Teacher getTeacher2(int id);
}
