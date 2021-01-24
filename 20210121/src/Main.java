//跳台阶
public class Main {
    public int JumpFloor(int target) {
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
