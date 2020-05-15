class Cat {
    private String name;
    public void eat(String food) {
        System.out.println(name+"正在吃"+food);
    }
    public Cat(String name) {
        this.name = name;
    }
}
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
       //三种获取类对象的方式
        //1
        Class catClass = Class.forName("Cat");

        //2
        Cat cat = new Cat("秘密");
        Class catClass2 = cat.getClass();

        //3
        Class catClass3 = Cat.class;

        System.out.println(catClass == catClass2);
        System.out.println(catClass == catClass3);



    }
}
