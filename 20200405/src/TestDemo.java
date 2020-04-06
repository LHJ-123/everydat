
class Money implements  Cloneable{
    public int money = 19;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable {
    public int age;
    public Money m;
    public Person(int age) {
        this.age = age;
        m = new Money();
    }

    @Override
    public String toString() {
        return "Person{" +
                "m=" + m +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person1 = (Person)super.clone();//克隆person
        person1.m = (Money)this.m.clone();//克隆m
        return person1;//要达到深拷贝，如果对象里面还有对象，都要拷贝
    }
}
public class TestDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        Person person = new Person(10);
        Person person1 = (Person)person.clone();
        System.out.println(person.m.money);
        System.out.println(person1.m.money);
        System.out.println("===============");
        person1.m.money = 200;
        System.out.println(person.m.money);
        System.out.println(person1.m.money);



    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);


        Person person1 = (Person)person.clone();
        System.out.println(person.age);
        System.out.println(person1.age);
        System.out.println("===============");
        person1.age = 444;
        System.out.println(person.age);
        System.out.println(person1.age);

    }
}
