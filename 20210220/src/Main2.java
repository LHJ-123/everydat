public class Main2 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        while (row>=0 && col<matrix[0].length) {
            if (target>matrix[row][col]) {
                col++;
            }else if (target<matrix[row][col]) {
                row--;
            }else {
                return true;
            }
        }
        return false;
    }
}
