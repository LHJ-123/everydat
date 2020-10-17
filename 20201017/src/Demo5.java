class Car {
    private String name;
    private int price;
    private String type;
    private String color;
    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Car(String name, int price, String type, String color, String size) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.color = color;
        this.size = size;
    }

    public Car() {
    }

public void fun1() {
    System.out.println("这是叫"+this.name+"的车");
}
    public void fun2() {
        System.out.println("这是价格为"+this.price+"的车");
    }
    public void fun3() {
        System.out.println("这是"+this.type+"类型的车");
    }
    public void fun4() {
        System.out.println("这是"+this.color+"颜色的车");
    }
    public void fun5() {
        System.out.println("这是大小为"+this.size+"的车");
    }

    public void inform()  {
        System.out.println(this.name+" "+this.price+" "+this.type
        +" "+this.color+" "+this.size);

    }
}
public class Demo5 {
    public static void main(String[] args) {
      /* Car car = new Car();
       car.setColor("红色");
       car.setName("兰博基尼");
       car.setPrice(1000000);
       car.setSize("small");
       car.setType("跑车");
       car.fun1();
       car.fun2();
       car.fun3();
       car.fun4();
       car.fun5();
       car.inform();
        System.out.println( car.getColor());
        System.out.println(car.getName());
        System.out.println(car.getPrice());
        System.out.println(car.getSize());
        System.out.println(car.getType());*/


        Car car1 = new Car("宝马",1100000,"跑车","紫色","mid");
        car1.fun1();
        car1.fun2();
        car1.fun3();
        car1.fun4();
        car1.fun5();
        car1.inform();

    }
}
