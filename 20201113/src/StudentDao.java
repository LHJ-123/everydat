import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
    public void add(Student student)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into Student values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getSno());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3,student.getSex());
            int ret = preparedStatement.executeUpdate();
            if (ret == 1 ) {
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }


    }

    public void delete(String sno) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from Student where sno = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sno);
            int ret = preparedStatement.executeUpdate();
            if (ret == 1 ) {
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }

    }

    public void update(String name,String sno) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update Student set name =? where sno =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,sno);
            int ret = preparedStatement.executeUpdate();
            if (ret == 1 ) {
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }

    public Student find(String sno) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from Student where sno = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sno);
            resultSet= preparedStatement.executeQuery();
            Student student = new Student();
           if (resultSet != null) {

               student.setSno(resultSet.getString("sno"));
               student.setName(resultSet.getString("name"));
               student.setSex(resultSet.getString("sex"));
               return student;
           }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
