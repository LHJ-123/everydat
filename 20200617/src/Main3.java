import java.util.Scanner;
public class Main3 {
    public static String GetSequeOddNum(int m) {
        int ret = m*m-m+1;
        int count = 0;
        int[] a = new int[m];
        while(count<m) {
            a[count] = ret;
            ret = ret+2;
            count++;
        }
        String[] x = new String[m];
        for(int i = 0;i<m;i++) {
            x[i] = Integer.toString(a[i]);
        }

        String s1 = "";
        for(int i = 0;i<m;i++) {
            if(i == 0) {
                s1 = s1+x[i];
                continue;
            }
            s1= s1+"+"+x[i];
        }
        return s1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String s3 = GetSequeOddNum(m);
        System.out.println(s3);
    }

}
