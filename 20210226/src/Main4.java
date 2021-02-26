public class Main4 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0||array == null) {
            return 0;
        }
        int prev = array[0];
        int count = 1;
        for (int i = 1;i<array.length;i++) {
            if (prev == array[i]) {
                count++;
            }else {
                count--;
                if (count == 0) {
                    prev = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;
        for (int i = 0;i<array.length;i++) {
            if (prev == array[i]) {
                num++;
            }
        }
        return (num>array.length/2)?prev:0;
    }
}
