public class Main2 {
    public static int[] multiply(int[] A) {
       int[] B = new int[A.length];
       for (int i = 0;i<B.length;i++) {
           B[i] = fun(A,i);
       }
       return B;
    }

    private static int fun(int[] a,int index) {
        int cur = 1;
        for (int i = 0;i<a.length;i++) {
            if (i == index) {
               continue;
            }else {
                cur = cur*a[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {

    }
}
