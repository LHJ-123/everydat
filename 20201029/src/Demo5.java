abstract class Shape {
    public abstract void Perimeter();
    public abstract void Area();
}
class Round extends Shape{
    int r;
    public Round(int r) {
        this.r = r;
    }

    @Override
    public void Perimeter() {
        System.out.println("圆的周长是:"+2*3.14*r);
    }

    @Override
    public void Area() {
        System.out.println("圆的面积是:"+3.14*r*r);
    }
}
class Rectangle extends Shape{
    int Long;
    int Wide;

    public Rectangle(int aLong, int wide) {
        Long = aLong;
        Wide = wide;
    }

    @Override
    public void Perimeter() {
        System.out.println("长方形的周长是:"+2*(Long+Wide));
    }

    @Override
    public void Area() {
        System.out.println("长方形的面积是:"+Long*Wide);
    }

}
class EqTriangle extends Shape{
    int SideLength;

    public EqTriangle(int sideLength) {
        SideLength = sideLength;
    }

    @Override
    public void Perimeter() {
        System.out.println("等边三角形的周长是:"+3*SideLength);
    }

    @Override
    public void Area() {
        System.out.println("等边三角形的面积是:"+0.43*SideLength);

    }

}
public class Demo5 {
    public static void main(String[] args) {
        Round round = new Round(2);
        Rectangle rectangle = new Rectangle(3,4);
        EqTriangle eqTriangle = new EqTriangle(1);
        round.Perimeter();
        round.Area();
        rectangle.Perimeter();
        rectangle.Area();
        eqTriangle.Perimeter();
        eqTriangle.Area();
    }
}