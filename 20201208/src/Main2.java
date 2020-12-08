import java.util.*;

public class Main2 {
    public int addAB(int A, int B) {
        // write code here
        if (A == 0) {
            return B;
        }else if (B == 0) {
            return A;
        }else {
            return addAB(A^B,(A&B)<<1);
        }
    }
}