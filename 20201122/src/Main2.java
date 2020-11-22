import java.util.Arrays;

public class Main2 {
    public static void quickSort(int[] a) {
        quickSortHelper(a,0,a.length-1);
    }

    private static void quickSortHelper(int[] a, int left, int right) {
        if (left>=right) {
            return;
        }
        int index = partition(a,left,right);
        quickSortHelper(a,left,index-1);
        quickSortHelper(a,index+1,right);
    }

    private static int partition(int[] a, int left, int right) {
        int baseValue = a[right];
        int cur1 = left;
        int cur2 = right;
        while (cur1<cur2) {
            while (cur1<cur2 && a[cur1]>=baseValue) {
                cur1++;
            }
            while (cur1<cur2 && a[cur2]<=baseValue) {
                cur2--;
            }
            if (cur1<cur2) {
                int tmp = a[cur1];
                a[cur1] = a[cur2];
                a[cur2] = tmp;
            }
        }
        int x = a[right];
        a[right] = a[cur1];
        a[cur1] = x;
        return cur1;

    }

    public static int findKth(int[] a, int n, int K) {
            // write code here
        quickSort(a);
        return a[K-1];

        }

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,2};
        //quickSort(arr);
        System.out.println(findKth(arr,5,3));
    }

}
