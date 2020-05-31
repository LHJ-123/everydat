import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        //创建dataSource对象
        DataSource dataSource = new MysqlDataSource();
       //对dataSource进行一些配置：URL，User,Password需要向下转型
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("xxxxxx");

        //建立连接
        //connection对象生命周期较短，每个请求都需创建一个新的connection
        Connection connection = dataSource.getConnection();
        //拼装sql语句PrepareStatement
        //以插入为例
        int id = 1;
        String name = "曹操";
        int classId = 10;
        String sql = "insert into student values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //1,2,3相当于刚才问号的下标，从1开始
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,classId);
        //执行sql
        //insert用executeUpdate
        //select 使用executeQuery来执行
        //返回值为操作修改了多少行
        int ret = statement.executeUpdate();
        System.out.println("ret: "+ ret);
        //关闭释放相关资源  后创建的被先释放
        statement.close();
        connection.close();

    }
}
