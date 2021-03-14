public class Main4 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0;i<B.length;i++) {
            B[i] = 1;
            for (int j = 0;j<A.length;j++) {
                if (j == i) {
                    continue;
                }
                B[i] = B[i]*A[j];
            }
        }
        return B;
    }
}
