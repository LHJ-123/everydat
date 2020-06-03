
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {




            int n = in.nextInt();
            if (n == 0) {
                break;
            }

            int count = 0;

            int w = 0;
            while (n >= 3) {

                w = n / 3;
                count = count + w;
                n = w+n%3;
            }
            if(n == 2) {
                count++;
            }
            System.out.println(count);



        }
    }

}
