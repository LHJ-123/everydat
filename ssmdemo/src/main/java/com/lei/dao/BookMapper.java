package com.lei.dao;

import com.lei.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BookMapper {

    int addBook(Books books);
    int deleteBookById( int id);
    int updateBook(Books books);
    Books queryBookById(int id);
    List<Books> queryAllBook();
    Books queryBookByName(String name);
}
