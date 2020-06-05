import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int kinds = in.nextInt();
            int[] arr = new int[kinds];
            for (int i = 0; i < kinds; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(differentkinds(arr, kinds, 40,0));
        }
    }

    static int differentkinds(int[] arr, int n, int v,int index) {
        if (v == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }else {
            //从后往前装，最后一个开始，装上n个后，体积减少，继续往前
            //装上n个后，如果无解。删除该包。然后从n-1开始继续往前装
            return differentkinds(arr,n-1,v-arr[index],index+1)
                    +differentkinds(arr,n-1,v,index+1);
        }
    }
}
