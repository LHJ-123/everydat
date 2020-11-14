import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil{
   private static volatile DataSource dataSource = null;
   private static DataSource getDataSource() {
      if (dataSource == null) {
         synchronized (DBUtil.class) {
            if (dataSource == null) {
               dataSource = new MysqlDataSource();
               ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student?characterEncoding=utf-8&useSSL=true");
               ((MysqlDataSource) dataSource).setUser("root");
               ((MysqlDataSource) dataSource).setPassword("xxxxxx");
            }
         }
      }
      return dataSource;
   }

   public static Connection getConnection() throws SQLException {

      Connection connection = getDataSource().getConnection();
      return connection;
   }

   public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {

      try {
         if (resultSet != null) {
            resultSet.close();
         }
         if (statement != null) {
            statement.close();
         }
         if (connection != null) {
            connection.close();
         }
      } catch (SQLException throwables) {
         throwables.printStackTrace();
      }


   }

}
