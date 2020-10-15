class Shape {
    public void draw() {

    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个圆!");
    }
}

class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("这是一个长方形!");
    }
}

class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("这是一朵花!");
    }
}

public class Demo3 {

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main1(String[] args) {
        Shape[] shapes = {new Cycle(),new Rect(),new Flower()};
        //Shape里的发生了向上转型

        for(Shape shape:shapes) {
            shape.draw();
        }
    }

    //降低了成本，简化了代码，容易进行扩展
    public static void main(String[] args) {
        Shape shape1 = new Cycle();
        Shape shape2 = new Rect();
        Shape shape3 = new Flower();
        // shape1.draw();
        //shape2.draw();
        //drawMap(shape1);
        //drawMap(shape2);
        //drawMap(shape3);
        Flower flower = new Flower();
        drawMap(flower);
    }
}
