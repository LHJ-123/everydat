import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            if(N == 0) {
                break;
            }

            int[] a = new int[1000];
            for(int i = 0;i<N;i++) {
                a[i] = in.nextInt();
            }
            int x = in.nextInt();
            int count = 0;
            for(int i = 0;i<N;i++) {
                if(x == a[i]) {
                    count++;
                }else {
                    continue;
                }
            }
            System.out.println(count);

        }

    }
}
