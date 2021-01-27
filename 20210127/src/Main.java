public class Main {
    //数组中出现次数超过一半的数字
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int pre = array[0];
        int count = 1;
        for (int i = 1;i<array.length;i++) {
            if (pre == array[i]) {
                count++;
            }else {
                count--;
                if (count == 0) {
                    pre = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;
        for (int i = 0;i<array.length;i++) {
            if (pre == array[i]) {
                num++;
            }
        }
        return (num>array.length/2)?pre:0;

    }
}
