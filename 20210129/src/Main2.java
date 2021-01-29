import java.util.Arrays;

public class Main2 {
    //数字在升序数组中出现的次数
    public int GetNumberOfK(int [] array , int k) {
        int index = Arrays.binarySearch(array,k);
        if (index<0) {
            return 0;
        }
        int count = 1;
        for (int i = index+1;i<array.length;i++) {
            if (array[i] == k) {
                count++;
            }
        }
        for (int i = index-1;i>=0;i--) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;

    }
}
