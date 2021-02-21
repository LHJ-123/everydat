public class Main2 {
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }

        int two = 0;
        int sum = 1;
        for (int i = 2;i<=target;i++) {
            two = sum-two;
            sum = sum+two;
        }
        return sum;

    }
}
