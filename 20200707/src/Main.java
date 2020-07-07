//day 32 1
import java.util.Scanner;
public class Main {
    public static boolean isBig(int[] a,int[] b) {
        for(int i = 0;i<3;i++) {
            if(b[i]>a[i]) {
                return true;
            }else if(b[i] == a[i]) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String[] a1 = s1.split("\\.");
            String[] a2 = s2.split("\\.");
            int[] i1 = new int[3];
            int[] i2 = new int[3];

            for(int i = 0;i<3;i++) {
                i1[i] = Integer.valueOf(a1[i]);
                i2[i] = Integer.valueOf(a2[i]);
            }
            int count = 0;
            int[] i3 = new int[3];
            if(isBig(i1,i2)) {
                count = 1;
               int jie = 0;
                    if(i1[2]<=i2[2]) {
                        i3[2] = i2[2]-i1[2];
                    }else {
                        i3[2] = i2[2]+29-i1[2];
                        jie = 1;
                    }
               if(i1[1]<=i2[1]-jie) {
                   i3[1] = i2[1]-jie-i1[1];
                   jie = 0;
               }else {
                   i3[1] = i2[1]-jie+17-i1[1];
                   jie = 1;
               }
               i3[0] = i2[0]-jie-i1[0];
            }else {
                count = -1;
                for (int i = 0;i<3;i++) {
                    int tmp = i1[i];
                    i1[i] = i2[i];
                    i2[i] = tmp;
                }
                int jie = 0;
                if(i1[2]<=i2[2]) {
                    i3[2] = i2[2]-i1[2];
                }else {
                    i3[2] = i2[2]+29-i1[2];
                    jie = 1;
                }
                if(i1[1]<=i2[1]-jie) {
                    i3[1] = i2[1]-jie-i1[1];
                    jie = 0;
                }else {
                    i3[1] = i2[1]-jie+17-i1[1];
                    jie = 1;
                }
                i3[0] = i2[0]-jie-i1[0];
            }
            if (count == 1) {
                for (int i = 0;i<3;i++) {
                    if (i!=2) {
                        System.out.print(i3[i]+".");
                    }else {
                        System.out.print(i3[i]);
                    }
                }
            }else {
                for (int i = 0;i<3;i++) {
                    if (i == 0) {
                        System.out.print("-"+i3[i]+".");
                    }else if (i == 2){
                        System.out.print(i3[i]);
                    }else {
                        System.out.print(i3[i]+".");
                    }
                }
            }

    }
}
