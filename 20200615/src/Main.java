import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        char C = in.next().charAt(0);
     /*   if(N == 3) {
            for(int i = 0;i<2;i++) {
                for(int j = 0;j<3;j++) {
                    System.out.print(C);
                }
                if (i!=1) {
                    System.out.println();
                }
            }
            return;
        }*/
        for(int i = 0;i<Math.round(N/2.0);i++) {
            if(i == 0 || i ==Math.round(N/2.0)-1) {
                for(int j = 0;j<N;j++ ) {
                    System.out.print(C);
                }
            }else {
                for(int j = 0;j<N;j++ ) {
                    if(j == 0 || j == N-1) {
                        System.out.print(C);
                    }else {
                        System.out.print(" ");
                    }
                }
            }
            if(i !=Math.round(N/2.0)-1 ) {
                System.out.println();
            }
        }
    }
}
