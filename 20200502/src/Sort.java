import java.util.Arrays;

//插入排序

public class Sort {
    //升序为例
    public static void insertSort(int[] array) {
        for (int bound = 1;bound<array.length;bound++) {
            int tmp = array[bound];
            int cur = bound-1;
            for (;cur>=0;cur--) {
                if (array[cur]>tmp) {
                    array[cur+1] = array[cur];

                }else {
                    break;
                }
            }
            array[cur+1] = tmp;
        }
    }
    //特性1：如果数组已经比较小了，使用插入排序效率非常高
    //特性2：如果数组本身已经接近有序，此时插入排序效率也很高

    //希尔排序
public static void shellSort(int[] array) {
        int gap = (array.length)/2;
        while (gap>1) {
            insertSortGap(array,gap);
            gap = gap/2;
        }
        insertSortGap(array,1);
}

public static void insertSortGap(int[] array,int gap) {
        for (int bound = gap;bound<array.length;bound++) {
            int tmp = array[bound];
            int cur = bound-gap;
            for (;cur>=0;cur-=gap) {
                if (array[cur]>tmp) {
                    array[cur+gap] = array[cur];
                }else {
                    break;
                }

            }
            array[cur+gap] = tmp;

        }
}

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6};
       // insertSort(array);
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
