//day31 1
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int len = s1.length;
        for(int i = len-1;i>=0;i--) {
            if(i != 0) {
                System.out.print(s1[i]+" ");
            }else {
                System.out.print(s1[i]);
            }
        }
    }
}