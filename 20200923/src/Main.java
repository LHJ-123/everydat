import java.util.Arrays;
        import java.util.Scanner;

public class Main {
    public static void bubbleSort(int[] array) {
        for(int bound = 0;bound<array.length;bound++) {
            for (int cur = array.length-1;cur>bound;cur--) {
                if(array[cur-1]>array[cur]) {
                    swap(array,cur-1,cur);
                }
            }
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        bubbleSort(arr);
        for (int i = 0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}