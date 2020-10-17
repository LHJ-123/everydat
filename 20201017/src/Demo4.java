import java.util.Scanner;

public class Demo4 {
    public static int add(int a,int b) {
        return a+b;

    }
    public static int sub(int a,int b) {
        return a-b;
    }
    public static int mul(int a,int b) {
        return a*b;
    }
    public static int div(int a,int b) {
        return a/b;
    }

    public static void Cal(int a,int b,String s) {
       if ("+".equals(s)) {
           System.out.println(add(a,b));
       }
        if ("-".equals(s)) {
            System.out.println(sub(a,b));
        }
        if ("*".equals(s)) {
            System.out.println(mul(a,b));
        }
        if ("/".equals(s)) {
            System.out.println(div(a,b));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Cal(a,b,s);


    }
}
