public class Main2 {
    //变态跳台阶
    //f[n] = 2*f[n-1]，初始条件f[0] = f[1] = 1
    public int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int a = 1;
        int b = 0;
        for (int i = 2;i<=target;i++) {
            b = a<<1;
            a = b;
        }
        return b;
    }
    public int JumpFloorII2(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return 2*JumpFloorII2(target-1);
    }
}
