public class Main {
    public int count = 0;
    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length);
        return count;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (right-left<=1) {
            return;
        }
        int mid = (right+left)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid,right);
        merge(array,mid,left,right);
    }

    private void merge(int[] array, int mid, int left, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right-left];
        int outputIndex = 0;
        while (cur1<mid&&cur2<right) {
            if (array[cur1]>=array[cur2]) {
                count = (count+mid-cur1)%1000000007;
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }else {
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            }
        }
        while (cur1<mid) {
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }
        while (cur2<right) {
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }
        for (int i = 0;i<right-left;i++) {
            array[left+i] = output[i];
        }
    }
}
