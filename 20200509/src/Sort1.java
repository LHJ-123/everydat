import java.util.Arrays;
import java.util.Stack;

//快速排序的非递归代码

public class Sort1 {
    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length-1);
        while (!stack.empty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left >= right) {
                continue;
            }
            int index = partition(array,left,right);
            stack.push(index+1);
            stack.push(right);
            stack.push(left);

            stack.push(index-1);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i<j && array[i] <= baseValue) {
                i++;
            }
            while (i<j && array[j] >= baseValue) {
                j--;
            }
            if (i < j) {
                swap(array,i,j);
            }

        }
        swap(array,i,right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //归并排序
    public static void mergeSort(int[] array) {
        mergeSortHelper(array,0,array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (right-left <= 1) { //前闭后开区间
            return;
        }
        int mid = (left+right)/2;
        mergeSortHelper(array,left,mid);
        mergeSortHelper(array,mid,right);
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right-left];
        int outputIndex = 0;
        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) { //  <=保证稳定性
                output[outputIndex] = array[cur1];
                cur1++;
                outputIndex++;
            }else {
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;
            }
        }
        while (cur1<mid) {
            output[outputIndex] = array[cur1];
            cur1++;
            outputIndex++;

        }
        while (cur2<right) {
            output[outputIndex] = array[cur2];
            cur2++;
            outputIndex++;
        }
        for (int i = 0;i<right-left;i++) {
            array[left+i] = output[i];
        }
    }
    public static void mergeSortByLoop(int[] array) {
        for (int gap = 1;gap<array.length;gap*=2) {
            for (int i = 0;i<array.length;i+=2*gap) {
                int left = i;
                int mid = i+gap;
                int right = i+2*gap;
                if (mid>array.length) {
                    mid = array.length;
                }
                if (right>array.length) {
                    right = array.length;
                }
                merge(array,left,mid,right);
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        //quickSortByLoop(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));

    }
}
