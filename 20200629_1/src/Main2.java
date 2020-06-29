//day25 第一题
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        int[] grade = new int[n];
        for(int i = 0;i<n;i++) {
            score[i] = in.nextInt();
        }
        for(int i = 0;i<n;i++) {
            grade[i] = in.nextInt();
        }
        double[] result = new double[n];
        for(int i = 0;i<n;i++) {
            if(grade[i]<=100&&grade[i]>=90) {
                result[i] = 4.0;
            }else if(grade[i]<=89&&grade[i]>=85) {
                result[i] = 3.7;
            }else if(grade[i]<=84&&grade[i]>=82) {
                result[i] = 3.3;
            }else if(grade[i]<=81&&grade[i]>=78) {
                result[i] = 3.0;
            }else if(grade[i]<=77&&grade[i]>=75) {
                result[i] = 2.7;
            }else if(grade[i]<=74&&grade[i]>=72) {
                result[i] = 2.3;
            }else if(grade[i]<=71&&grade[i]>=68) {
                result[i] = 2.0;
            }else if(grade[i]<=67&&grade[i]>=64) {
                result[i] = 1.5;
            }else if(grade[i]<=63&&grade[i]>=60) {
                result[i] = 1.0;
            }else {
                result[i] = 0;
            }
        }
        double[] y = new double[n];
        for(int i = 0;i<n;i++) {
            y[i] = result[i]*score[i];
        }
        double sum1 = 0;
        int sum2 = 0;
        for(int i = 0;i<n;i++) {
            sum1 = sum1+y[i];
            sum2 = sum2+score[i];
        }
        double GPA = sum1/sum2;
        System.out.printf("%.2f",GPA);
    }
}
