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

/*
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

*/

/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        double ret = avgArray(array);
        System.out.println(ret);
    }

    public static double avgArray(int[] array) {
        double ret = 0;
        for(int i = 0;i<array.length;i++) {

            ret = ret +array[i];
        }
        double x = ret/(array.length);
        return x;
    }
}
*/

/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int ret = sumArray(array);
        System.out.println(ret);
    }

    public static int sumArray(int[] array) {
        int ret = 0;
        for(int i = 0;i<array.length;i++) {

            ret = ret +array[i];
        }

        return ret;
    }
}


*/

/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] ret = transformArray(array);
        System.out.println(Arrays.toString(ret));
    }

    public static int[] transformArray(int[] array) {
        int[] array2 = new int[array.length];
        for(int i = 0;i<array.length;i++) {
                array2[i] = array[i]*2;

        }

        return array2;
    }
}

*/

/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
         printArray(array);

    }

    public static void printArray(int[] array) {

        for(int i = 0;i<array.length;i++) {

            System.out.println(array[i]);
        }


    }
}
*/
/*
public class TestDemo1 {
    public static void main(String[] args) {
        int[] array = new int[100];
        int a = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = a;
            a++;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }


    }
}*/

/*
    public static void printArray(int[] array) {

        for(int i = 0;i<array.length;i++) {

            System.out.println(array[i]);
        }


    }
}

*/
