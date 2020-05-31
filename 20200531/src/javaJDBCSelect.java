import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class javaJDBCSelect {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("xxxxxx");
        Connection connection = dataSource.getConnection();
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //ResultSet新的类，表示查找结果集
        ResultSet resultSet =  statement.executeQuery();
        //遍历结果集(相当于一张表，里面有很多行，每行又是一条记录）
        //next（）一方面判断是否存在下一行，如果存在就获取这一行
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int classId = resultSet.getInt("classId");
            System.out.println("id:" +id+"name:"+name+"classId: "+classId);

        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
