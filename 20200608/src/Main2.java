import java.util.Scanner;
public class Main2 {
    public static int min(int a,int b) {
        if(a<b) {
            int m = b;
            b = a;
            a = m;
        }
        while(b!=0) {
            if(a == b) {
                return a;
            }
            int k = a%b;
            a = b;
            b = k;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int x = min(A,B);
        int n = A*B/x;
        System.out.println(n);
    }
}
