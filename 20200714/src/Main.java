import java.util.Arrays;
import java.util.Scanner;
//day37 1
public class Main {
    public static int Sum(int[] a,int i) {
        int sum = 0;
        for (int x = 0;x<a.length;x++) {
            if (x != i) {
                sum = sum+a[x];
            }
        }
        return sum;
    }
    public static void Judge(int[] a) {
        int count = 0;
        for (int i = 0;i<a.length;i++) {
            if (a[i] != 0) {
                count++;
            }
        }
        if (count<3) {
            System.out.println("No");
            return;
        }
        Arrays.sort(a);
        if (Sum(a,a.length-1)>a[a.length-1]) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        int[] array3 = new int[n];
        for (int i = 0;i<array1.length;i++) {
            array1[i] = scanner.nextInt();
            array2[i] = scanner.nextInt();
        }
        for (int i = 0;i<array1.length;i++) {
            if (array1[i] == 1) {
                array3[i] = array2[i];
            }else {
                for (int j = 0;j<array3.length;j++) {
                    if (array3[j] == array2[i]) {
                        for (int x = j;x<array3.length-1;x++) {
                            array3[x] = array3[x+1];
                        }
                        break;
                    }
                }
            }
            int[] array4 = new int[n];
            for (int m = 0;m<array3.length;m++) {
                array4[m] = array3[m];
            }
            //System.out.println(Arrays.toString(array3));
            Judge(array3);
            for (int m = 0;m<array4.length;m++) {
                array3[m] = array4[m];
            }
        }
    }
}
