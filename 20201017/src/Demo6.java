import java.util.Arrays;
import java.util.Collections;

public class Demo6 {
    public static String[] stringSort(String[] s,String[] s2) {
        int n = s.length+s2.length;
        String[] s3 = new String[n];
        int curIndex = 0;
        for (int i = 0;i<s.length;i++) {
            s3[curIndex] = s[i];
            curIndex++;
        }
        for (int j = 0;j<s2.length;j++) {
           s3[curIndex] = s2[j];
            curIndex++;
        }
        Arrays.sort(s3);
       return s3;
    }
    public static int[] intIntersect(int[] a,int[] b) {
        int n = a.length>b.length?b.length:a.length;
        int n1 = a.length<b.length?b.length:a.length;
        int isMin = 0;
        if (n == a.length) {
            isMin = 1;
        }else {
            isMin = 0;
        }
        int[] result = new int[n];
        int curIndex = 0;
        if (isMin == 1) {
            for (int i = 0;i<n;i++) {
                for (int j = 0;j<n1;j++) {
                    if (a[i] == b[j]) {
                        result[curIndex] = a[i];
                        curIndex++;
                    }
                }
            }
        }else {
            for (int i = 0;i<n;i++) {
                for (int j = 0;j<n1;j++) {
                    if (b[i] == a[j]) {
                        result[curIndex] = b[i];
                        curIndex++;
                    }
                }
            }
        }
        if (curIndex == n) {
            return result;
        }else {
            int[] result1 = new int[curIndex];
            for (int i = 0;i<curIndex;i++) {
                result1[i] = result[i];
            }
            return result1;
        }

    }
    public static double[] doubleUnion(double[] a,double[] b) {
        int n = a.length+b.length;
        double[] result = new double[n];
        int curIndex = 0;
        for (int i = 0;i<a.length;i++) {
            result[curIndex] = a[i];
            curIndex++;
        }
        for (int j = 0;j<b.length;j++) {
            result[curIndex] = b[j];
            curIndex++;
        }
        int size = result.length;
        for (int i = 0;i<result.length;i++) {

            for (int j = i+1;j<size;j++) {
                if (result[i] == result[j]) {
                    for (int m = j;m<size-1;m++) {
                        result[m] = result[m+1];
                    }
                    size--;
                }
            }
        }
        double[] result1 = new double[size];
        for (int i = 0;i<size;i++) {
            result1[i] = result[i];
        }
        return result1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {2,3,4,5};
        double[] c = {2.3,4.4,5.5};
        double[] d = {3.3,4.4,5.5,6.6};
        int[] result = intIntersect(a,b);
        double[] result2 = doubleUnion(c,d);
        String[] s = {"ss","aa"};
        String[] s1 = {"bb","cc"};
        String[] s3 = stringSort(s,s1);
        System.out.println(Arrays.toString(s3));
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));

    }
}
