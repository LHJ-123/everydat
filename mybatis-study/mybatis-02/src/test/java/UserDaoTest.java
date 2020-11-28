import com.lei.dao.UserDao;
import com.lei.pojo.User;
import com.lei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }


    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User(3,"王五","333");
        int i = mapper.addUser(user);
        if (i>0) {
            System.out.println("插入成功");
        }
        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int i = mapper.updateUser(new User(2, "哈哈", "321"));
        if (i>0) {
            System.out.println("更新成功");
        }
        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int i = mapper.deleteUser(1);
        if (i>0) {
            System.out.println("删除成功");
        }
        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
