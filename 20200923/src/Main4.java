import java.util.Scanner;

public class Main4 {
    public static void selectSort(int[] array) {
        for(int i = 0;i<array.length;i++) {
            for (int j = i;j<array.length;j++) {
                if(array[i]>array[j]) {
                    swap(array,i,j);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        selectSort(arr);
        for (int i = n-1;i>=0;i--) {
            System.out.print(arr[i]+" ");
        }
    }
}
