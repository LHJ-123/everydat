import java.util.Scanner;

public class Main1 {
    public static void quickSort(int[] array,int k) {
        quickSortHelper(array,0,k);
    }

    public static void quickSortHelper(int[] array, int left, int right) {
        if(left>=right) {
            return;
        }
        /*int index = partition(array,left,right);
        quickSortHelper(array,left,index-1);*/
        //quickSortHelper(array,index+1,right);
      /*  left = index+1;*/

        //尾递归优化
        int index = 0;
        while (left<right) {
            index = partition(array,left,right);
            quickSortHelper(array,left,index-1);
            left = index+1;
        }

    }

    public static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i<j) {
            while (i<j && array[i]<=baseValue) {
                i++;
            }
            while (i<j && array[j]>=baseValue ) {
                j--;
            }
            if (i<j) {
                swap(array,i,j);
            }
        }
        swap(array,i,right);
        return i;
    }
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[200010];
        for (int i = 0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(arr,n-1);
        for (int i = 0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
