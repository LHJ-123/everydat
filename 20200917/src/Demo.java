public class Demo {
    //输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的
    //最大值。要求时间复杂度为O(n)
    public  int findBiggerSumOfArr(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("数组为空");
        }
        // max用来记录最大的子数组和，因为有负数存在，所以设置为MIN_VALUE而不能为0
        int max = Integer.MIN_VALUE;
        int tmpMax = 0;
        for (int x:array) {
            // 如果当前的和tmpMax小于等于0，就重新设置当前和;如果当前和大于0，累加当前和
            //这样做就可以简化逻辑，因为如果遍历到i号元素时的和tmpMax（假设从0开始遍历，那么这里的tmpMax就是0至i-1的和）是非正数。就可以将tmpMax的值直接给成i，为什么呢？
            //因为如果此时的i为正数，那再好不过
            // 如果为负数，我们也不慌，因为max变量记录了tmpMax的值，如果i作为负数比tmpMax还小，虽然本次i依旧会赋值给tmpMax，
            // 但是根据下面if (max < tmpMax)的判断，最终max还是上一轮tmpMax的值，所以逻辑是通的。
            if (tmpMax<=0) {
                tmpMax = x;
            }else {
                tmpMax = tmpMax+x;
            }
            if (tmpMax>max) {
                max = tmpMax;
            }
        }
        return max;
    }

   /* public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        int ret = findBiggerSumOfArr(arr);
        System.out.println(ret);
    }*/
}
