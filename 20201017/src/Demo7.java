class Team {
    Teacher t;
    Postgraduate p;
    Undergraduate u;

    public Team(Teacher t, Postgraduate p, Undergraduate u) {
        this.t = t;
        this.p = p;
        this.u = u;
    }
   public void inform() {
       System.out.println("成员有:");
       System.out.println(this.t);
       System.out.println("======");
       System.out.println(this.p);
       System.out.println("======");
       System.out.println(this.u);
   }
}
class Teacher {
    String name;
    String sex;
    int age;

    public Teacher(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "名字='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 年龄=" + age +
                '}';
    }
}
class Postgraduate {
    String name;
    String sex;
    int age;
    String pro;

    public Postgraduate(String name, String sex, int age, String pro) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.pro = pro;
    }

    @Override
    public String toString() {
        return "Postgraduate{" +
                "名字='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 年龄=" + age +
                ", 专业='" + pro + '\'' +
                '}';
    }
}
class Undergraduate {
    String name;
    String sex;
    int age;
    String pro;

    public Undergraduate(String name, String sex, int age, String pro) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.pro = pro;
    }

    @Override
    public String toString() {
        return "Undergraduate{" +
                "名字='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 年龄=" + age +
                ", 专业='" + pro + '\'' +
                '}';
    }
}
public class Demo7 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("李明","男",30);
        Postgraduate postgraduate = new Postgraduate("小红","女",22,"化学");
        Undergraduate undergraduate = new Undergraduate("小葱","男",19,"计算机");
        Team team = new Team(teacher,postgraduate,undergraduate);
        team.inform();

    }
}
