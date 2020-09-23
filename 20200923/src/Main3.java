import java.util.Scanner;

public class Main3 {
    public static void shellSort(int[] array) {
        int gap = (array.length)/2;
        while (gap>1) {
            insertSortGap(array,gap);
            gap = gap/2;
        }
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap;bound<array.length;bound++) {
            int tmp = array[bound];
            int cur = bound-gap;
            for (;cur>=0;cur -= gap) {
                if (array[cur]>tmp) {
                    array[cur+gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur+gap] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        shellSort(arr);
        for (int i = 0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
