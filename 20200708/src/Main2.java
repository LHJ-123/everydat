//day33 1
import java.util.Scanner;
public class Main2 {
    public static String Pok1(int n,int[] a) {
        if (n == a[0]) {
            return "B";
        }
        if (n == a[1]) {
            return "C";
        }
        if (n == a[2]) {
            return "J";
        }
        return null;
    }
    public static String Pok2(int n,int[] b) {
        if (n == b[0]) {
            return "B";
        }
        if (n == b[1]) {
            return "C";
        }
        if (n == b[2]) {
            return "J";
        }

        return null;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] S1 = new String[N];
        String[] S2 = new String[N];
        for(int i = 0;i<N;i++) {
            S1[i] = in.next();
            S2[i] = in.next();
        }
        int S1Y = 0;
        int S1S = 0;
        int P = 0;
        int a1 = 0;
        int b1 = 0;
        int c1 = 0;
        int a2 = 0;
        int b2 = 0;
        int c2 = 0;
        for(int i = 0;i<N;i++) {
            if(S1[i].equals("C")&&S2[i].equals("J")) {
                S1Y++;
                a1++;
            }
            if(S1[i].equals("J")&&S2[i].equals("B")) {
                S1Y++;
                b1++;
            }
            if(S1[i].equals("B")&&S2[i].equals("C")) {
                S1Y++;
                c1++;
            }
            if(S1[i].equals("C")&&S2[i].equals("B")) {
                S1S++;
                a2++;
            }
            if(S1[i].equals("J")&&S2[i].equals("C")) {
                S1S++;
                b2++;
            }
            if(S1[i].equals("B")&&S2[i].equals("J")) {
                S1S++;
                c2++;
            }
            if(S1[i].equals("C")&&S2[i].equals("C")) {
                P++;
            }
            if(S1[i].equals("B")&&S2[i].equals("B")) {
                P++;
            }
            if(S1[i].equals("J")&&S2[i].equals("J")) {
                P++;
            }
        }
        int[] x1 = new int[3];
        int[] x2 = new int[3];
        x1[0] = c1;
        x1[1] = a1;
        x1[2] = b1;
        x2[0] = a2;
        x2[1] = b2;
        x2[2] = c2;
        System.out.println(S1Y+" "+P+" "+S1S);
        System.out.println(S1S+" "+P+" "+S1Y);
        int umax1 = 0;
        int umax2 = 0;
        int max1 = 0;
        int max2 = 0;
        for(int i = 0;i<3;i++) {
           if(x1[i]>umax1) {
               max1 = i;
               umax1 = x1[i];
           }
           if(x2[i]>umax2) {
               max2 = i;
               umax2 = x2[i];
           }
        }
        System.out.println(Pok1(x1[max1],x1)+" "+Pok2(x2[max2],x2));
    }
}