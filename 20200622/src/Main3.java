import java.util.Scanner;
public class Main3 {
    public static void bubbleSort(int[] a,String[] b) {
        for(int i = 0;i<a.length;i++) {
            for(int j = a.length-1;j>i;j--) {
                if(a[j-1]<a[j]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                    String s = b[j];
                    b[j] = b[j-1];
                    b[j-1] = s;
                }
            }
        }
    }
    public static void bubbleSort1(int[] a,String[] b) {
        for(int i = 0;i<a.length;i++) {
            for(int j = a.length-1;j>i;j--) {
                if(a[j-1]>a[j]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                    String s = b[j];
                    b[j] = b[j-1];
                    b[j-1] = s;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int num = in.nextInt();
            String[] s = new String[n];
            int[] a = new int[n];
            for(int i = 0;i<n;i++) {
                s[i] = in.next();
                a[i] = in.nextInt();
            }
            if(num == 0) {
                bubbleSort(a,s);
            }else {
                bubbleSort1(a,s);
            }

            for(int i = 0;i<n;i++) {
                System.out.println(s[i]+" "+a[i]);
            }
        }
    }
}