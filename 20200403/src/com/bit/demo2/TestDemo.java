package com.bit.demo2;
//1.接口
//2.里面的数据成员是一个常量
//3.成员里面的方法默认是：public abstract
//4.不可以定义一个已经实现的方法
//5.JDK1.8新特性：可以有实现方法，但必须是被default修饰的。
//6.类和接口为实现关系：implements
//7.解决了单继承问题
//8.实现了该接口，一定要重写该接口中的方法
//9.接口也不可以被实例化
//10.接口也可以发生向上转型
//11.接口是不能用接口实现的，可以用extends联系起来
interface IShape{
    //public int a = 10;
    void draw();
}
interface S{

}
class Cycle implements IShape ,S{    //可以实现多个接口
    @Override
    public void draw() {
        System.out.println("这是一个圆!");
    }
}
class Rect implements IShape {
    @Override
    public void draw() {
        System.out.println("这是一个长方形!");
    }
}

class Flower implements IShape {
    @Override
    public void draw() {
        System.out.println("这是一朵花!");
    }
}
public class TestDemo {
    public static void drawMap(IShape shape) {
        shape.draw();
    }
    public static void main(String[] args) {

        IShape shape1 = new Cycle();
        IShape shape2 = new Rect();
        IShape shape3 = new Flower();
        // shape1.draw();
        //shape2.draw();
        drawMap(shape1);
        drawMap(shape2);
        drawMap(shape3);


    }
}
