import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};

        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reverse(int[] array) {

        int left = 0;
        int right = array.length-1;
        int tmp = 0;
        while(left<right) {
            tmp = array[right];
            array[right] = array[left];
            array[left] = tmp;
            left++;
            right--;


        }

    }

}

