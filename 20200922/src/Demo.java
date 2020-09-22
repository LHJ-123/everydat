import java.util.Arrays;


//旋转数组
public class Demo {
    public  void rotaArray(char[] array,int k) {
        if(k == 0 || k == array.length) {
            return;
        }
        char[] arr = new char[k];
        char[] arr1 = new char[array.length-k];
        for (int i = 0;i<k;i++) {
            arr[i] = array[i];
        }
        int x = 0;
        for (int j = k;j<array.length;j++) {
            if (x<array.length-k) {
                arr1[x] = array[j];
                x++;
            }
        }
        int n = 0;
        for (int i = array.length-k;i<array.length;i++) {
            if (n<k) {
                array[i] = arr[n];
                n++;
            }
        }
        int m = 0;
        for (int j = 0;j<array.length-k;j++) {
            if (m<array.length-k) {
                array[j] = arr1[m];
                m++;
            }
        }
    }

   /* public static void main(String[] args) {
        char[] arr = {'a','b','c','d','e','f'};
        rotaArray(arr,2);
        System.out.println(Arrays.toString(arr));
    }*/
}
