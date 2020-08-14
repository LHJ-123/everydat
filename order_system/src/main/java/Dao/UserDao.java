package Dao;

import model.DBUtil;
import model.User;
import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//插入用户
//按名字查找用户
//按照用户ID查找
public class UserDao {
   public void add(User user) throws OrderSystemException, SQLException {
       Connection connection = DBUtil.getConnection();
       PreparedStatement preparedStatement = null;
       try {

           String sql = "insert into user values(null,?,?,?)";

           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1,user.getPassword());
           preparedStatement.setInt(2,user.getIsAdmin());
           preparedStatement.setString(3,user.getName());
           int ret = preparedStatement.executeUpdate();
           if (ret != 1) {
              throw new OrderSystemException("插入用户失败");
           }
           System.out.println("插入用户成功");
       } catch (SQLException | OrderSystemException e) {
           e.printStackTrace();
           throw new OrderSystemException("插入用户失败");
       }finally {
           DBUtil.close(connection,preparedStatement,null);
       }
   }

   public User selectByName(String name) throws SQLException {
       Connection connection = DBUtil.getConnection();
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       try {
           String sql = "select * from user where name = ?";
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1,name);
           resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
            User user = new User();
            user.setUserId(resultSet.getInt("userId"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setIsAdmin(resultSet.getInt("isAdmin"));
            return user;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           DBUtil.close(connection,preparedStatement,resultSet);
       }
       return null;
   }
   public User selectById(int userId) throws SQLException, OrderSystemException {
       Connection connection = DBUtil.getConnection();
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       try {
           String sql = "select * from user where userId=?";
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setInt(1,userId);
           resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               User user = new User();
               user.setUserId(resultSet.getInt("userId"));
               user.setName(resultSet.getString("name"));
               user.setPassword(resultSet.getString("password"));
               user.setIsAdmin(resultSet.getInt("isAdmin"));
               return user;
           }
       } catch (SQLException e) {
           e.printStackTrace();
           throw new OrderSystemException("按id查找用户失败");
       } finally {
           DBUtil.close(connection,preparedStatement,resultSet);
       }
       return null;
   }

    public static void main(String[] args) throws OrderSystemException, SQLException {
        UserDao userDao = new UserDao();
        /*User user = new User();
        user.setName("雷浩杰");
        user.setPassword("123456");
        user.setIsAdmin(0);
        userDao.add(user);*/
       /* User user = userDao.selectByName("雷浩杰");
        System.out.println(user);
        User user1 = userDao.selectById(1);
        System.out.println(user1);*/
    }
}
