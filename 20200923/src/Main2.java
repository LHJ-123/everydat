import java.util.Scanner;

public class Main2 {
    public static void insertSort(int[] array) {
        for (int bound = 1;bound<array.length;bound++) {
            int tmp = array[bound];
            int cur = bound-1;
            for(;cur>=0;cur--) {
                //写成大于等于就变成了不稳定排序了
                if (array[cur]>tmp) {
                    array[cur+1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur+1] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        insertSort(arr);
        for (int i = 0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

