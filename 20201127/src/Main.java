import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int x = (a+c)/2;
        int y = (b+d)/2;
        int z = (d-b)/2;
        if (x-y==a && y-z==b && x+y==c && y+z==d) {
            System.out.println(x+" "+y+" "+z);
        }else {
            System.out.println("No");
        }
    }
}
