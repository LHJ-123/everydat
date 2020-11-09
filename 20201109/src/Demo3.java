import java.io.*;

class Student implements Serializable {
    String name;
    int age;
    String sex;
}
public class Demo3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Student student = new Student();
        student.name = "雷浩杰";
        student.age = 20;
        student.sex = "男";
        serializeStudent(student);*/
        Student s = disserializeStudent();
        System.out.println(s.age);
        System.out.println(s.name);
        System.out.println(s.sex);
    }

    private static Student disserializeStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("F:\\2.txt"));
        Student s = (Student)objectInputStream.readObject();
        return s;
    }

    //序列化
    private static void serializeStudent(Student student) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("F:\\2.txt"));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }
}
