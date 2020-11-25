import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        if (n == 0) {
            count = -1;
        }
        if (n%8 == 0) {
            count = n/8;
            System.out.println(count);
            return;
        }
        if (n%8 < 6) {
            count = n/8-1;
            if ((n-count*8)%6 == 0) {
                count = count+(n-count*8)/6;
            }else if (n%6 == 0){
                count = count/6;
            }else {
                count = -1;
            }
        }else if (n%8 == 6) {
            count = count/8+1;
        }else {
            count = -1;
        }
        System.out.println(count);
    }
}
