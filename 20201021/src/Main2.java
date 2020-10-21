import java.util.Scanner;

public class Main2 {
    public static int count = 0;
    public static void move() {
        count++;
    }

    public static void hanoi(int n) {
        if (n == 1) {
            move();
            return;
        }
        hanoi(n - 1);
        move();
        hanoi(n - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        hanoi(n);
        System.out.println(count);
    }
}
