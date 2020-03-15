import java.util.Arrays;
import java.util.Scanner;
//import java.lang.String;
/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        print(array2);
    }

    public static void print(int[] array) {
        for(int i = 0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();

    }
}
*/

/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array2 = {10,20};
        System.out.println(array2[0]+" "+array2[1]);
        swap(array2);
        System.out.println(array2[0]+" "+array2[1]);
    }

    public static void swap(int[] array) {
        int tmp;
       tmp = array[1];
       array[1] = array[0];
       array[0] = tmp;

    }
}

*/

/*
public class TestDemo1 {
    public static void main(String[] args) {

    }

    public static void swap(int[] array) {
        int tmp;
        tmp = array[1];
        array[1] = array[0];
        array[0] = tmp;

    }
}
*/

/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] ret = func2();
        System.out.println(Arrays.toString(ret));
    }

    public static int[] func2() {
        int[] array = {1,2,3,4,5,6};
        return array;

    }
}
*/






/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(myToString(array));
    }

    public static String myToString(int[] array) {
        String ret = "[";
        for(int i = 0;i<array.length;i++) {
            ret = ret+array[i];
            if(i!=array.length-1) {
                ret = ret+",";
            }
        }
        ret =ret+"]";
        return ret;

    }
}
*/

public class TestDemo1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] ret = copyArray(array);
        System.out.println(Arrays.toString(ret));
    }

    public static int[] copyArray(int[] array) {
       int[] array2 = new int[array.length];
       for(int i = 0;i<array.length;i++) {
           array2[i] = array[i];
       }
        return array2;
    }
}

