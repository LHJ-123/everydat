import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] n = new int[a][b];
        for(int i = 0;i<a;i++) {
            for(int j = 0;j<b;j++) {
                if(n[i][j] != 5) {
                    n[i][j] = 1;
                    if(i-2>=0) {
                        n[i-2][j] = 5;
                    }
                    if(i+2<=a-1) {
                        n[i+2][j] = 5;
                    }
                    if(j-2>=0) {
                        n[i][j-2] = 5;
                    }
                    if(j+2<=b-1) {
                        n[i][j+2] = 5;
                    }
                }else {
                    continue;
                }
            }
        }
        int count = 0;
        for(int i = 0;i<a;i++) {
            for(int j = 0;j<b;j++) {
                if(n[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
