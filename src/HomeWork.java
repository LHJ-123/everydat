import java.util.Scanner;
public class HomeWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 1;
        int tmp = n;
        while(true) {
            if(tmp/10!=0) {
                count++;
                tmp = tmp/10;
            }
            break;
        }

        for(int i = 1;i<=count;i++) {
            n = n%10;
            System.out.println(n);
        }
    }
}