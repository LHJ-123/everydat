import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int A = (a+c)/2;
        int B = (c-a)/2;
        int C = (d-b)/2;
        if(A-B == a && B-C == b && A+B == c && B+C == d) {
            System.out.println(A+" "+B+" "+C);
        }else {
            System.out.println("No");
        }
    }
}
