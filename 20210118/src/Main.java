public class Main {
    public static boolean Find(int target, int [][] array) {
        int n = array.length;
        if (n == 0) {
            return false;
        }
        int m = array[0].length;
        if (m == 0) {
            return false;
        }
        int row = n-1;
        int col = 0;
        while (row>=0&&col<m) {
            if (array[row][col]<target) {
                col++;
            }else if (array[row][col]>target) {
                row--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
