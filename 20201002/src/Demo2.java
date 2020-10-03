import java.util.Scanner;

public class Demo2 {
    public  int findSumIsN(int[] array,int n) {
        int count = 0;
        for (int i = 0;i<array.length;i++) {
            int sum = 0;
            for (int j = i;j<array.length;j++) {
                sum = sum+array[j];
                if(n<sum) {
                    break;
                }
                if (n>sum) {
                    continue;
                }
                if (n == sum) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = {3,2,1,4,1};
        int ret = findSumIsN(array,n);
        System.out.println(ret);
    }*/
}
