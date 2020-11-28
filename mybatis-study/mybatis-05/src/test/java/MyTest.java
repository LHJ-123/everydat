import com.lei.dao.StudentMapper;
import com.lei.dao.TeacherMapper;
import com.lei.pojo.Student;
import com.lei.pojo.Teacher;
import com.lei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyTest {
  /*  public static void main1(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
    }*/
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getStudent();
        for (Student s:list) {
            System.out.println(s);
        }
        sqlSession.close();
    }
    public static void main2(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getStudent2();
        for (Student s:list) {
            System.out.println(s);
        }
        sqlSession.close();
    }
}
