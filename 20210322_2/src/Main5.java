public class Main5 {
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
        int two = 2;
        for (int i = 3;i<=target;i++) {
            two = one+two;
            one = two-one;
        }
        return two;

    }
}
