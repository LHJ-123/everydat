public class Main {
    //矩阵中的路径
    public int[][] visit;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        visit = new int[rows][cols];
        char[][] array = new char[rows][cols];
        //将字符串中的每个字符放入二维数组中
        for (int i = 0;i<rows;i++) {
            for (int j = 0;j<cols;j++) {
                array[i][j] = matrix[i*cols+j];
            }
        }
        //遍历数组找起始点并判断是否存在路径
        for (int i = 0;i<rows;i++) {
            for (int j = 0;j<cols;j++) {
                if (find(array,rows,cols,str,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] array, int rows, int cols, char[] str, int i, int j, int index)  {
        //字符串中的所有字符都已找到说明路径存在
        if (index>=str.length) {
            return true;
        }
        //数值出界或者当前数值不等于字符串中路径对应值或者该位置已经被经过
        if (i<0||j<0||i>=rows||j>=cols||array[i][j]!=str[index]||visit[i][j] == 1) {
            return false;
        }
        //标记该位置
        visit[i][j] = 1;
        //递归找是否存在满足条件的路径
        boolean isSunc = find(array,rows,cols,str,i+1,j,index+1)
                ||find(array,rows,cols,str,i,j+1,index+1)
                ||find(array,rows,cols,str,i-1,j,index+1)
                ||find(array,rows,cols,str,i,j-1,index+1);
        //将标记位复原方便下一测试用例判断
        visit[i][j] = 0;
        return isSunc;

    }
}
