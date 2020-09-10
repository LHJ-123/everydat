class Add {
    public int a = 1;
    public int ww() {
        return a++;
    }
}
public class Test1 {
    public static void main(String[] args) {
        Add add = new Add();
        Add add1 = new Add();
        int n = add.ww();
        int n1 = add.ww();
        int m = add1.ww();
        System.out.println(n1+" "+n+" "+m);
        System.out.println(add1.ww());
    }
}
