import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;



abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}
 interface IEat {
void eat();
}
interface ISleep {
    void sleep();
}
interface IThink {
    void think();
}
interface ISpeak {
    void speak();
}
interface IFly {
    void fly();
}
class Cat extends Animal implements IEat,ISleep{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name+"正在吃");

    }

    @Override
    public void sleep() {
        System.out.println(name+"正在睡");

    }
}
class People extends Animal implements IEat,ISleep,IThink,ISpeak{
    public People(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name+"正在吃");

    }

    @Override
    public void sleep() {
        System.out.println(name+"正在睡");

    }

    @Override
    public void speak() {
        System.out.println(name+"正在说话");

    }

    @Override
    public void think() {
        System.out.println(name+"正在想");

    }
}
class Bird extends Animal implements IEat,ISleep,IFly{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name+"正在吃");
    }

    @Override
    public void fly() {
        System.out.println(name+"正在飞");
    }

    @Override
    public void sleep() {
        System.out.println(name+"正在睡");
    }
}
public class Demo6 {
    public static void main(String[] args) {
        Cat cat = new Cat("猫");
        People people = new People("人");
        Bird bird = new Bird("鸟");
        cat.eat();
        cat.sleep();
        people.eat();
        people.sleep();
        people.speak();
        people.think();
        bird.fly();
        bird.eat();
        bird.sleep();
    }
}
