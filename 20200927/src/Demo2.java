import java.util.Scanner;

public class Demo2 {
    public  boolean isTwoMul(int n) {

        while (n%2 == 0) {
           n = n/2;
           if (n == 0) {
               break;
           }
        }
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return true;
        }else {
            return false;
        }
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(isTwoMul(x));
    }*/
}
