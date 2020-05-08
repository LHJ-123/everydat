import java.util.Arrays;

public class Sort {
    //选择排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound<array.length;bound++) {
            for (int cur = bound;cur<array.length;cur++) {
                if (array[cur]<array[bound]) {
                    swap(array,cur,bound);
                }
            }
        }
    }

    private static void swap(int[] array, int cur, int bound) {
        int tmp = array[cur];
        array[cur] = array[bound];
        array[bound] = tmp;
    }
    //堆排序
    public static void heapSort(int[] array) {
        createHeap(array);
        int heapSize = array.length;
        for (int i = 0;i<array.length-1;i++) {
            swap(array,0,heapSize-1);
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0;bound<array.length;bound++) {
            for (int cur = array.length-1;cur>bound;cur--) {
                if (array[cur-1]>array[cur]) {
                    swap(array,cur-1,cur);
                }
            }
        }
    }
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
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i<j) {
            while (i<j && array[i]<=baseValue) {
                i++;
            }
            while (i<j&&array[j]>=baseValue) {
                j--;
            }
            if (i<j) {
                swap(array,i,j);
            }
        }
        swap(array,i,right);
        return i;
    }


    private static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2;i>=0;i--) {
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int heapSize, int i) {
        int parent = i;
        int child = 2*parent+1;
        while (child<heapSize) {
            if (child+1<heapSize && array[child+1]>array[child]) {
                child = child+1;
            }
            if (array[child]>array[parent]) {
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = 2*parent+1;
        }

    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        //selectSort(array);
       // heapSort(array);
       // bubbleSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
