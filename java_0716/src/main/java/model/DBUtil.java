package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//管理数据库连接
//1.建立连接
//2.断开连接
//JDBC中使用DataSource来管理连接
//DBUtil相当于是对DataSource再稍微包装一层
//因为DataSource每个应用程序应该只有一个实例（单例）
//本质就是实现了一个单例模式，管理了唯一一个DataSource实例
//饿汉模式
//懒汉模式
//此处用懒汉模式
public class DBUtil {
    private static volatile DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java_blogdemo?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "xxxxxx";
    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);

                }
            }
        }
        return dataSource;
    }

    //通过这个方法获取连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//通过这个来断开连接
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
          if (resultSet != null) {
              try {
                  resultSet.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
          if (preparedStatement != null) {
              try {
                  preparedStatement.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
          if (connection != null) {
              try {
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
    }
}
