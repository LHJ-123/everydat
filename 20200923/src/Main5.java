import java.util.Scanner;

public class Main5 {
    public static void heapSort(int[] array) {
        buildTree(array);
        int heapTreeSize = array.length;
        while (heapTreeSize>1) {
            swap(array,0,heapTreeSize-1);
            heapTreeSize--;
            shiftDown(array,heapTreeSize,0);
        }
    }

    private static void shiftDown(int[] array, int heapTreeSize, int i) {
        int parent = i;
        int child = 2*parent+1;
        while (child<heapTreeSize) {
            if (child+1<heapTreeSize && array[child+1]>array[child]) {
                child = child+1;
            }
            if(array[child]>array[parent]) {
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = parent*2+1;
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void buildTree(int[] array) {
        for (int i = (array.length-1-1)/2;i>=0;i--) {
            shiftDown(array,array.length,i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        heapSort(arr);
        for (int i = 0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
