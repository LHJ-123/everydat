public class Main2 {
    public int cutRope(int target) {
        if (target<=1) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int Length = target%3 == 0?target/3:target/3+1;
        int Length2 = target%3 == 0?0:3-target%3;
        int result = 1;
        for (int i = 0;i<Length;i++) {
            result = result*(i<(Length-Length2)?3:2);
        }
        return result;
    }
}
