/*class Calculator {
    private int num1;
    private int num2;
    public int add() {
        return this.num1+this.num2;
    }
    public int sub() {
        return this.num1-this.num2;
    }
    public int mul() {
         return this.num1+this.num2;
    }
    public double dev() {
         return (double)this.num1/this.num2;
    }

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(12,23);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.dev());

    }
}*/

/*
class Swap {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
public class TestDemo {
    public static void x2(Swap swap1,Swap swap2) {
        int tmp = swap2.getA();
        swap2.setA(swap1.getA());
        swap1.setA(tmp);

    }
    public static void main(String[] args) {
        Swap swap1 = new Swap();
        swap1.setA(10);
        Swap swap2 = new Swap();
        swap2.setA(20);
        System.out.println(swap1.getA()+" "+swap2.getA());
        x2(swap1,swap2);
        System.out.println(swap1.getA()+" "+swap2.getA());
    }
}*/


/*
class Swap {
    public int a;


}
public class TestDemo {
    public static void x2(Swap swap1,Swap swap2) {
        int tmp = swap2.a;
        swap2.a = swap1.a;
        swap1.a = tmp;

    }
    public static void main(String[] args) {
        Swap swap1 = new Swap();
        swap1.a = 10;
        Swap swap2 = new Swap();
        swap2.a = 20;
        System.out.println(swap1.a+" "+swap2.a);
        x2(swap1,swap2);
        System.out.println(swap1.a+" "+swap2.a);
    }
}
*/
public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,10);
        myArrayList.add(1,20);
        myArrayList.add(2,30);
        myArrayList.add(3,40);
        myArrayList.remove(20);
        myArrayList.display();
        System.out.println(myArrayList.contains(50));
        System.out.println(myArrayList.search(30));
        System.out.println(myArrayList.getPos(0));

    }
}
