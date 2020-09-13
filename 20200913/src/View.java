//递归练习
public class View {
    //正序输出1 2 3
    public void print(int n) {
        if(n>9) {
            print(n/10);
        }
        System.out.println(n%10);
    }

    //输入非负数，返回组成他数字的和
    public int numSum(int n) {
        if (n<10) {
            return n;
        }
        return n%10+numSum(n/10);
    }

    //汉诺塔问题
    public void move(char n,char m) {
        System.out.println(n+"->"+m+" ");
    }

    public void hanoi(int n,char x1,char x2,char x3) {
        if (n == 1) {
            move(x1,x3);
            return;
        }
        hanoi(n-1,x1,x3,x2);
        move(x1,x3);
        hanoi(n-1, x2, x1, x3);
    }

    //青蛙跳台阶
    public int fac(int n) {
        if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }else {
            return fac(n-2)+fac(n-1);
        }
    }
}
