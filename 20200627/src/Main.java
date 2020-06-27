//day 23
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for(int i = 0;i<N;i++) {
            num[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i = 0;i<N;i++) {
            if(num[i]%10 == 0) {
                sum = sum+num[i];
            }
        }
        if(sum == 0) {
            System.out.print("N"+" ");
        }else {
            System.out.print(sum+" ");
        }
        int[] result = new int[N];
        int count = 0;
        for(int i = 0;i<N;i++) {
            if(num[i]%5 == 1) {
                result[count] = num[i];
                count++;
            }
        }
        int sum2 = 0;
        if(count == 0) {
            System.out.print("N"+" ");
        }else {
            for(int i = 0;i<result.length;i++) {
                if(i%2 == 0) {
                    sum2 = sum2+result[i];
                }else {
                    sum2 = sum2-result[i];
                }
            }
            System.out.print(sum2+" ");
        }
        int sum3 = 0;
        for(int i = 0;i<N;i++) {
            if(num[i]%5 == 2) {
                sum3++;
            }
        }
        if(sum3 == 0) {
            System.out.print("N"+" ");
        }else {
            System.out.print(sum3+" ");
        }
        int[] result1 = new int[N];
        int count1 = 0;
        double ret = 0;
        double sum4 = 0;
        for(int i = 0;i<N;i++) {
            if(num[i]%5 == 3) {
                result1[count1] = num[i];
                count1++;
            }
        }
        if(count1 == 0) {
            System.out.print("N"+" ");
        }else {
            for(int i = 0;i<result1.length;i++) {
                ret = ret+result1[i];
            }
            sum4 = ret/count1;
            System.out.format("%.1f ",sum4);
        }
        int[] result2 = new int[N];
        int count2 = 0;
        for(int i = 0;i<N;i++) {
            if(num[i]%5 == 4) {
                result2[count2] = num[i];
                count2++;
            }
        }
        int max = 0;
        if(count2 == 0) {
            System.out.print("N");
        }else {
            for(int i = 0;i<result2.length;i++) {
                if(max<result2[i]) {
                    max = result2[i];
                }
            }
            System.out.print(max);
        }
    }
}