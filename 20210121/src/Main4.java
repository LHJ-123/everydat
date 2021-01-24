public class Main4 {
    //二进制中1的个数
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n&1) == 1 ) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
    public int NumberOf12(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
