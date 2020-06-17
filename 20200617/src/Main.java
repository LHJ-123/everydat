import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        int[] a = new int[10];
        while(i<10) {
            a[i] = in.nextInt();
            i++;
        }
        List<Integer> list = new ArrayList<>();
        for (int x = 0;x < 10;x++) {
            for(int y = 0; y < a[x];y++) {
                list.add(x);
            }
        }
        int[] b = new int[list.size()];
        int m = 0;
        for(int d:list) {
            b[m] = d;
            m++;
        }
        Arrays.sort(b);
        if(b[0] != 0) {
            for(int y = 0;y<b.length;y++) {
                System.out.print(b[y]);
            }
        }else {
            for(int y = 0;y<b.length;y++) {
                if(b[y] == 0) {
                    continue;
                }
                int tmp = b[0];
                b[0] = b[y];
                b[y] = tmp;
                break;
            }
            for(int y = 0;y<b.length;y++) {
                System.out.print(b[y]);
            }
        }
    }
}
