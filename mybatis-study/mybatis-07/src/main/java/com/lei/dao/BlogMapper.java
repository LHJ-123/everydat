package com.lei.dao;

import com.lei.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);
    List<Blog> findBlogIF(Map map);
    List<Blog> findBlogChoose(Map map);
    int updateBlog(Map map);
    //查询1,2,3号博客
    List<Blog> findBlogForeach(Map map);
}
