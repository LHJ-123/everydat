import com.lei.dao.BlogMapper;
import com.lei.pojo.Blog;
import com.lei.utils.IdUtils;
import com.lei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {

    @Test
    public void addBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis1");
        blog.setAuthor("王五");
        blog.setCreateTime(new Date());
        blog.setViews (9999);
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle( "mybatis2");
        mapper .addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle( "mybatis3");
        mapper.addBlog(blog);

        blog.setId (IdUtils.getId());
        blog.setTitle("mybatis4");
        mapper.addBlog(blog);

        sqlSession.close();

    }

    @Test
    public void findBlogIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("title","mybatis3");
        map.put("author","王五");
        map.put("views",9999);
        List<Blog> blogIF = mapper.findBlogIF(map);
        for (Blog blog:blogIF) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("title","mybatis311");
        map.put("author","王五11");
        map.put("id", "a6f0037b230044fbabacc788387cf2e8");
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void findBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);
        List<Blog> blogForeach = mapper.findBlogForeach(map);
        for (Blog blog:blogForeach) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
