public class Main3 {
    //矩形覆盖
    //f[n] = f[n-1] + f[n-2]，初始条件f[1] = 1, f[2] =2
    public int rectCover(int target) {
        if(target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int sum = 2;
        int one = 1;
        for (int i = 3;i<=target;i++) {
            sum = sum+one;
            one = sum-one;
        }
        return sum;

    }
}
