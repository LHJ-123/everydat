/*
class Person {
    public String name ;
    public int age ;
    public static int count = 20;
    public final int SIZE = 10;
    public void eat() {
        System.out.println("吃饭!");
    }
    public void sleep() {
        System.out.println("睡觉!");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "李四";
        person.age = 23;
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(Person.count);
        System.out.println(person.SIZE);
        person.eat();
        person.sleep();
    }


}
*/

/*class Person {
    private String name ;
    private int age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/
    /* public void setName(String userName) {
    name = userName;
 }
    public String getName() {
        return name;
    }
    public void setAge(int userAge) {
        age = userAge;
    }
    public int getAge() {
        return age;
    }*/


/*
public class TestDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(22);
        person.setName("caocao");
        System.out.println(person.getAge());
        System.out.println(person.getName());

    }
}*/


/*class Test {
    public static void hello() {
        System.out.println("hello");
    }
}*/
/*
public class TestDemo {

        public static void main(String[] args){

            String s;

            System.out.println("s="+s);

        }

}*/
/*
public class TestDemo {
    public int aMethod(){
        int i = 0;
        i++;
        return i;
    }
    public static void main(String args[]){
        TestDemo test = new TestDemo();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
}*/
/*
public class TestDemo{
    static boolean Paddy;
    public static void main(String args[]){
        System.out.println(Paddy);
    }
}*/

/*
public class Person{

    private String name = "Person";

    int age=0;

}

public class TestDemo{

    public String grade;

    public static void main(String[] args){

        Person p = new Child();

        System.out.println(p.name);

    }

}*/
/*public class TestDemo {// 1
    private static int x = 100;// 2
    public static void main(String args[]) {// 3
     TestDemo hsl = new TestDemo();// 4
        hsl.x++;// 5
        TestDemo hs2 = new TestDemo();// 6
        hs2.x++;// 7
        hsl = new TestDemo();// 8
        hsl.x++;// 9
       TestDemo.x--;// 10
        System.out.println(" x=" + x);// 11
    }
}*/
public class TestDemo{

    private int count;

    public static void main(String[] args) {

        TestDemo test=new TestDemo(88);

        System.out.println(test.count);

    }

    TestDemo(int a) {

        count=a;

    }

}