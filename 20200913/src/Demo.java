import java.util.Arrays;

public class Demo {
    public  int[] findTopK(int[] array,int k) {
        int[] arr = new int[k];
        for (int i = 0;i<array.length;i++) {
            for (int j = i;j<array.length;j++) {
                if (array[i]>array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        for (int i = 0;i<k;i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    /*public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        int[] arr = findTopK(array,3);
        System.out.println(Arrays.toString(arr));
    }*/
}
