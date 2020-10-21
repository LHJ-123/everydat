import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void quickSort(int[] array) {
        quickSortHelper(array,0,array.length-1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left>=right) {
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int value = array[right];
        int cur1 = left;
        int cur2 = right;
        while (cur1<cur2) {
            while (cur1<cur2 && array[cur1]<=value) {
                cur1++;
            }
            while (cur1<cur2 && array[cur2]>=value) {
                cur2--;
            }
            if (cur1<cur2) {
                int tmp = array[cur1];
                array[cur1] = array[cur2];
                array[cur2] = tmp;
            }
        }
        int tmp = array[cur1];
        array[cur1] = array[right];
        array[right] = tmp;
        return cur1;
    }

    public static int findTopK(int[] array,int k) {
        quickSort(array);
        return array[k-1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0;i<array.length;i++) {
            array[i] = scanner.nextInt();
        }
        int ret = findTopK(array,k);
        System.out.println(ret);
    }
}
