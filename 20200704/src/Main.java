//day29 2
import java.util.Scanner;
public class Main {
    public static int differentkinds(int[] A,int a,int b,int index) {
        if(b == 0) {
            return 1;
        }
        if(a == 0) {
            return 0;
        }
        return differentkinds(A,a-1,b-A[index],index+1)
                +differentkinds(A,a-1,b,index+1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] A  = new int[n];
        for(int i = 0;i<n;i++) {
            A[i] = in.nextInt();
        }
        System.out.println(differentkinds(A,n,sum,0));
        //}
    }
}