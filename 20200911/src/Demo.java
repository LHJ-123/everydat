import java.util.Arrays;

public class Demo {
    public  void Parity(int[] array) {
        int i = 0;
        int j = array.length-1;
        while (i<j) {
            while (i<j && array[i]%2 != 0) {
                i++;
            }
            while (i<j && array[j]%2 == 0) {
                j--;
            }
            if(i<j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }

    /*public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Parity(array);
        System.out.println(Arrays.toString(array));
    }*/



    public static void main(String[] args) {

    }
}
