/*
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        int x = maxOfArray(array);
        System.out.println(x);
    }
    public static int maxOfArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}

/*
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        double x = avgOfArray(array);
        System.out.println(x);
    }
    public static double avgOfArray(int[] array) {
        double sum = 0;
      for(int i:array) {
          sum = sum+i;
      }
      return sum/array.length;
    }
}
*/

/*
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        int x = 4;
        int ret = binarySearch(array,x);
        System.out.println(ret);
    }
    public static int binarySearch(int[] array,int key) {
       int left = 0;
       int right = array.length-1;
       while(left<=right) {
           int min = (left+right)/2;
           if(key<array[min]) {
               right = min-1;

           }else if(key>array[min]) {
               left = min+1;
           }else {
               return min;
           }
       }
       return -1;
    }
}
*/

import java.util.Arrays;

/*
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,4,3,5,8,7,6};

        int[] ret = bubbleSort(array);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] bubbleSort(int[] array) {
        for(int i = 0;i<array.length-1;i++) {
            for(int j = 0;j<array.length-1-i;j++) {
                int tmp = 0;
                if(array[j]>array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }
}
*/


/*
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,4,3,5,8,7,6};

         reverse(array);
        System.out.println(Arrays.toString(array));
    }
    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length-1;
        while(left<right) {
            int tmp = 0;
            tmp = array[right];
            array[right] = array[left];
            array[left] = tmp;
            left++;
            right--;
        }


    }
}
*/

/*
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,4,3,5,8,7,6};

        func(array);
        System.out.println(Arrays.toString(array));
    }
    public static void func(int[] array) {
        int left = 0;
        int right = array.length-1;
        while(left<right) {
            while(left<right && array[left]%2==0){
                left++;
            }
            while(left<right && array[right]%2!=0){
                right--;
            }
            int tmp = 0;
            tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }

    }
}*/


/*public class TestDemo {
    public static void main(String[] args) {
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        for(int i = 0;i<array2.length;i++) {
            for(int j = 0;j<array2[i].length;j++) {
                System.out.print(array2[i][j]+" ");
            }
            System.out.println();
        }
    }
}*/

/*
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,4,3,5,8,7,6};

        boolean ret = func(array);
        System.out.println(ret);
    }
    public static boolean func(int[] array) {
        for(int i = 0;i<array.length-1;i++) {
            if(array[i]<array[i+1]) {
                return true;
            }
        }
        return false;

    }
}
*/

public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,2,4,3,5,8,7,6};

         String ret = myToString(array);
        System.out.println(ret);
    }
    public static String myToString(int[] array) {
        String ret = "[";
        for(int i = 0;i<array.length;i++) {
            ret = ret+array[i];
            if(i!=array.length-1) {
                ret = ret+",";
            }
        }
        ret = ret+"]";
        return ret;
    }
}
