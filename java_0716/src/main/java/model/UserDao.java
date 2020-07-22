package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//UserDao是常见的命名方式，表示数据访问操作
public class UserDao {
    //新增用户（注册）
    //把一个User对象插入到数据库中
    public void add(User user)  {
        //1.获取数据连接
        Connection connection = DBUtil.getConnection();
        //2.拼装SQL语句
        String sql = "insert into user values (null,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            //3.执行SQL语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("插入用户失败");
                return;
            }
            System.out.println("插入新用户成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.释放数据库连接
            DBUtil.close(connection,statement,null);
        }

    }
    //按照名字查找用户（登录）
    public User selectByName(String name)  {
        //建立连接
        Connection connection = DBUtil.getConnection();

        //拼装SQL
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            //执行SQL
            resultSet = statement.executeQuery();
            //遍历结果集
            if (resultSet.next()) {
                User user = new  User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放连接
            DBUtil.close(connection,statement,resultSet);
        }
      return null;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
      /*  User user = new User();
        user.setName("lhj");
        user.setPassword("1314");
        userDao.add(user);*/
      User user = userDao.selectByName("lhj");
        System.out.println(user);
    }

    public User selectById(int userId) {
        Connection connection = DBUtil.getConnection();

        //拼装SQL
        String sql = "select * from user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            //执行SQL
            resultSet = statement.executeQuery();
            //遍历结果集
            if (resultSet.next()) {
                User user = new  User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放连接
            DBUtil.close(connection,statement,resultSet);
        }
        return null;

    }
}
