public class TestDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Bird bird = new Bird("将死",23);
        Animal animal = new Bird("初一",12);
        //向上转型
       // Animal animal = new Animal("将军");

        bird.eat();
    }
}
//子类中不能访问父类私有的属性和方法
//java中只能继承一个类
//子类继承了父类除构造方法外的所有东西，对于父类中的私有东西，只是不能够访问

//若子类要构造，首先得构造父类
//只能在子类中调用父类的构造方法
//如果一个类不想被继承，加个final