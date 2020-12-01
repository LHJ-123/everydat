public class SortView {
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
            for (;cur>=0;cur-=gap) {
                if (array[cur]>tmp) {
                    array[cur+gap]=array[cur];
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
    public void bubbleSort(int[] array) {
        for (int bound = 0;bound<array.length;bound++) {
            for (int cur = array.length-1;cur>bound;cur--) {
                if (array[cur-1]>array[cur]) {
                    swap(array,cur-1,cur);
                }
            }
        }
    }
}
