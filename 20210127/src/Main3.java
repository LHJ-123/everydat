public class Main3 {
    //连续子数组的最大和
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int max= array[0];
        for (int i = 1;i<array.length;i++) {
            array[i] += array[i-1]>0?array[i-1]:0;
            max = Math.max(max,array[i]);
        }
        return max;
    }
}
