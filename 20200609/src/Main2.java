
import java.util.Arrays;
import java.util.Scanner;


public class Main2 {
  /*  public static void selectSort(int[] array) {
        for (int i = 0;i<array.length;i++) {
            for (int j = i;j<array.length;j++) {
                if (array[i]>array[j]) {
                    swap(array,i,j);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int[] a = new int[strs.length-1];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(strs[i]);
        }
        int k = Integer.valueOf(strs[a.length]);
       /* System.out.println(Arrays.toString(a));
        System.out.println(k);*/
        Arrays.sort(a);
        for(int i = 0;i<k;i++) {
            System.out.print(a[i]+" ");
        }
    }
}