import java.util.HashMap;
import java.util.Map;

class Student {
    public String name;
    public int age;
    public String grade;
    public String school;

    public Student(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
public class TestMap {
    //一个Map只能维护一组映射关系，若需要多组映射，就需要多个Map。
    //只能通过key找到value
    //对于get方法，如果key不存在，返回null
    //对于getOrDefault,如果key不存在，返回默认值
    //put方法若key不存在，就会创建新的键值对
    //若存在，就会修改value的值

    public static void main(String[] args) {
        Student s1 = new Student("蔡徐坤",20,"大四","陕科大");
        Student s2 = new Student("罗志祥",30,"大三","家里蹲");
        Student s3 = new Student("人才",40,"大一","外国语");
        Map<String,Student> studentMap = new HashMap<>();
        studentMap.put(s1.name,s1);
        studentMap.put(s2.name,s2);
        studentMap.put(s3.name,s3);
        String name = "蔡徐坤";
        String name1 = "厉害";
        Student student = studentMap.get(name);
        Student student1 = studentMap.getOrDefault(name1,new Student("moren ",10,"moren","moren"));

        System.out.println(student);
        System.out.println(student1);

        //遍历一个Map
        for (Map.Entry<String,Student> entry:studentMap.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
