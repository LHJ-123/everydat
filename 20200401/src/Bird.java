public class Bird extends  Animal {
    public int age;

    public Bird(String name,int age) {
        super(name);    //只能调用一次
        this.age = age;
    }


    public void fly() {
        System.out.println(this.name + "正在飞!");
    }
    public void eat() {
        System.out.println(this.name + "正在吃!");
        System.out.println(super.name);
    }
}
