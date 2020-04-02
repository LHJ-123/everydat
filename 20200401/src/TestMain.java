import java.util.concurrent.Callable;

class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public void  eat() {
        System.out.println(this.name+"正在吃！");
    }

}

class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }
    public void fly() {
        System.out.println(this.name+"正在飞！");
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}

public class TestMain {
    public static void main(String[] args) {
        Animal animal = new Bird("初一");//向上转型
        animal.eat();
        //animal.fly();//不可调用父类中没有的方法或属性

        Bird bird = (Bird)animal;//向下转型   不安全
        bird.fly();
    }

    public static void main1(String[] args) {
        Animal animal = new Animal("将军");
        Bird bird = new Bird("初一");
        Cat cat = new Cat("咪咪");


    }
}


