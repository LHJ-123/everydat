import java.util.Stack;

public class SortView2 {
    public void insertSort(int[] array) {
        for (int bound = 1;bound<array.length;bound++) {
            int tmp = array[bound];
            int cur = bound-1;
            for (;cur>=0;cur--) {
                if (array[cur]>tmp) {
                    array[cur+1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur+1] = tmp;
        }
    }
    public void shellSort(int[] array) {
        int gap = (array.length)/2;
        while (gap>1) {
            insertSortGap(array,gap);
            gap = gap/2;
        }
        insertSortGap(array,1);
    }

    private void insertSortGap(int[] array, int gap) {
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
    public void selectSort(int[] array) {
        for (int i = 0;i<array.length;i++) {
            for (int j = i;j<array.length;j++) {
                if (array[i]>array[j]) {
                    swap(array,i,j);
                }
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public void heapSort(int[] array) {
       buildTree(array);
       int heapTreeSize = array.length;
       while (heapTreeSize >1) {
           swap(array,0,heapTreeSize-1);
           heapTreeSize--;
           shiftDown(array,heapTreeSize,0);
       }

    }

    private void shiftDown(int[] array, int heapTreeSize, int i) {
        int parent = i;
        int child = 2*parent+1;
        while (child<heapTreeSize) {
            if (child+1<heapTreeSize && array[child]<array[child+1]) {
                child = child+1;
            }
            if (array[child]>array[parent]) {
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = parent*2+1;
        }
    }

    private void buildTree(int[] array) {
        for (int i = (array.length-1-1)/2;i>=0;i--) {
            shiftDown(array,array.length,i);
        }
    }
    public void bubbleSort(int[] array) {
        for (int bound = 0;bound<array.length;bound++) {
            for (int cur = array.length-1;cur>bound;cur--) {
                if (array[cur-1]>array[cur]) {
                    swap(array,cur-1,cur);
                }
            }
        }
    }
    public void quickSort(int[] array) {
        quickSortHelper(array,0,array.length-1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left>=right) {
            return;
        }
        int index = partition(array,left,right);
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index+1,right);

    }

    private int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i<j) {
            while (i<j && array[i]<=baseValue) {
                i++;
            }
            while (i<j && array[j]>=baseValue) {
                j--;
            }
            if (i<j) {
                swap(array,i,j);
            }
        }
        swap(array,i,right);
        return i;
    }
    public void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length-1);
        while (!stack.empty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left>=right) {
                continue;
            }
            int index = partition(array,left,right);
            stack.push(index+1);
            stack.push(right);
            stack.push(left);
            stack.push(index-1);
        }
    }
    public void mergeSort(int[] array) {
        mergeSortHelper(array,0,array.length);
    }

    private void mergeSortHelper(int[] array, int left, int right) {
        if (right-left<=1) {
            return;
        }
        int mid = (left+right)/2;
        mergeSortHelper(array,left,mid);
        mergeSortHelper(array,mid,right);
        merge(array,left,mid,right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right-left];
        int outputIndex = 0;
        while (cur1<mid && cur2<right) {
            if (array[cur1]>=array[cur2]) {
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;
            }else {
                output[outputIndex] = array[cur1];
                cur1++;
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
}
