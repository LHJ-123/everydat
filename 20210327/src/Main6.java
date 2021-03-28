public class Main6 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null||array.length == 0) {
            return -1;
        }
        int max = array[0];
        for (int i = 1;i<array.length;i++) {
            array[i]+=array[i-1]>0?array[i-1]:0;
            max = Math.max(array[i],max);
        }
        return max;
    }
}
