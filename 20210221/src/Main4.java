public class Main4 {
    public int rectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int one = 1;
        int sum = 2;
        for (int i = 3;i<=target;i++) {
            sum = sum+one;
            one = sum-one;
        }
        return sum;
    }
}
