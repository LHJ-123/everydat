public class Main4 {
    public int jumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return 2*jumpFloorII(target-1);
    }
}
