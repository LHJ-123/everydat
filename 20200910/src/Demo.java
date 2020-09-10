

public class Demo {
    public boolean isNum(int[][] array,int n) {
        int row = array.length;
        int col = array[0].length;
        int i = 0;
        int j = col-1;

        while (i<=row-1 && j>=0) {
            if(array[i][j] == n) {
                return true;
            }
            if(array[i][j] > n) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

   
}
