import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String w = n+"";
        for(int i = w.length()-1;i>=0;i--) {
            System.out.print(w.charAt(i));
        }
    }
}