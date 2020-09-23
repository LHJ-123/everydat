import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main8 {
    public static void radixSort(int[] nums) {
        // 找最大值，确定数组中元素的最长位数maxLength，从而循环maxLength次
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        // 元素最大长度（位数）
        int maxLength = (max + "").length();

        // 定义一个二维数组来确定10个桶，每个桶是一维数组
        // 每个桶最多有nums.length个元素
        int[][] bucket = new int[10][nums.length];
        // 创建一个一维数组，来确定10个桶中每个存放多少个数据
        // buckElementCounts[0]=2 即表示 bucket[0]桶中有2个数据
        int[] bucketElementsCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            // 对每个元素的个位进行排序
            for (int j = 0; j < nums.length; j++) {
                // 确定个位yuansu
                int digitOfElement = nums[j] / n % 10;
                bucket[digitOfElement][bucketElementsCounts[digitOfElement]] = nums[j];
                bucketElementsCounts[digitOfElement]++;
            }
            int index = 0;
            // 遍历每个桶，并将桶中数据放入原数组,
            for (int k = 0; k < bucketElementsCounts.length; k++) {
                // 桶中有数据，放入原数组
                if (bucketElementsCounts[k] != 0) {// 说明有数据
                    // 遍历第k个桶
                    for (int l = 0; l < bucketElementsCounts[k]; l++) {
                        nums[index++] = bucket[k][l];
                    }
                }
                bucketElementsCounts[k] = 0;
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
        radixSort(arr);
        for (int i = 0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
