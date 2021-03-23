public class Main3 {
    public int JumpFloor(int target) {
        // 1 1
        //2 2
        //3 3
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int one = 1;
        int two = 2;
        for (int i = 3;i<=target;i++) {
            two = one+two;
            one = two-one;
        }
        return two;
    }
}
