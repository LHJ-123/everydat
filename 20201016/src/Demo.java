//如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
// 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。


//输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
public class Demo {
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
