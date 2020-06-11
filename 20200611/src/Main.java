import java.util.Scanner;
public class Main {
    public static int func(int i) {
        if(i == 0) {
            return 0;
        }
        if(i == 1) {
            return 1;
        }
        return func(i-1)+func(i-2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N  = in.nextInt();
        int i = 0;
        for( i = 0;i<=1000000;i++) {
            int ret = func(i);
            if(ret == N) {
                System.out.println(0);
                return;
            }
            if(ret<N) {
                continue;
            }
            if(ret>N) {
                break;
            }
        }
        int step = N-func(i-1)>func(i)-N?func(i)-N:N-func(i-1);
        System.out.println(step);
    }

}
