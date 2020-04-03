package com.bit.demo1;

//1.抽象类可以有普通类的所有属性
//2.与普通类不一样的是包含了抽象方法
//3.不能被实例化
//4.就是用来被继承的
//5.不能被final所修饰
//6.抽象方法  不能是私有的，也不能是static
//7.只要有一个类继承了该抽象方法，就需要重写抽象类里面的方法。
abstract class Shape {
    //如果方法你不想实现，可以变为  抽象类
    public abstract void draw() ;


}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个圆!");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个长方形!");
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一朵花!");
    }
}
public class TestDemo {

    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        Shape shape1 = new Cycle();
        Shape shape2 = new Rect();
        Shape shape3 = new Flower();
        // shape1.draw();
        //shape2.draw();
        drawMap(shape1);
        drawMap(shape2);
        drawMap(shape3);

    }
}
