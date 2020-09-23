import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main7 {
    public static void bucketSort(int[] array) {
        int Default_Interval = 10;        //默认的间隔

        if (array == null || array.length <= 0) {
            return ;
        }

        //获得最大值,最小值,
        int min, max;
        min = array[0];
        max = array[1];
        for (int a : array) {
            if (a > max) {
                max = a;
            } else if (a < min) {
                min = a;
            }
        }

        // 计算出桶数,并根据默认的间隔创建桶
        int bucketNum = (max - min) / Default_Interval + 1;
        ArrayList<Integer>[] buckets = new ArrayList[bucketNum];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // 将数据填入桶中
        for (int a : array) {
            int index = (a - min) / Default_Interval;
            buckets[index].add(a);
        }

        // 对每个桶中的数据进行排序
        for (ArrayList bucket : buckets) {
            Collections.sort(bucket);
        }

        // 将桶中元素赋值到原来数列中
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int i = 0; i < bucket.size(); i++) {
                array[index++] = bucket.get(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        bucketSort(arr);
        for (int i = 0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
