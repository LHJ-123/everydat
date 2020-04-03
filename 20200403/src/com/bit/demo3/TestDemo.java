package com.bit.demo3;

class Animal{
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
}
interface IFlying{
    void fly();
}
interface IRunning{
    void run();
}
interface ISwimming{
    void swim();
}
class Cat extends Animal implements IRunning{
    public Cat(String name) {
        super(name);
    }


    public void run() {
        System.out.println(this.name+"正在用四条腿跑");
    }
}

class Frog extends Animal implements IRunning,ISwimming{
    public Frog(String name) {
        super(name);
    }


    @Override
    public void run() {
        System.out.println(this.name+"正在往前跳");

    }

    @Override
    public void swim() {
        System.out.println(this.name+"正在蹬腿游泳");

    }
}
public class TestDemo {
//参数用接口的类型
    public static void walk(IRunning iRunning) {
        iRunning.run();
    }
    public static void swim(ISwimming iSwimming) {
        iSwimming.swim();
    }
    public static void main(String[] args) {
        Cat cat = new Cat("笑话");
        walk(cat); //只要是实现了run接口的，都可以传进来
        Frog frog = new Frog("小娃");
        walk(frog);
        swim(frog);

    }
}
