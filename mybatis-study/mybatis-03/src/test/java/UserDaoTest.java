import com.lei.dao.UserDao;
import com.lei.pojo.User;
import com.lei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {



    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("a",0);
        map.put("b",2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user:userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }


}
