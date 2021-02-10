public class Main2 {
    //机器人的运动范围
    public int movingCount(int threshold, int rows, int cols){
        int count = 0;
        for (int i = 0;i<rows;i++) {
            for (int j = 0;j<cols;j++) {
                int sum1 = 0;
                int sum2 = 0;
                while (i%10!=0) {
                    sum1 +=i%10;
                    i = i/10;
                }
                while (j%10!=0) {
                    sum2 +=i%10;
                    j = j/10;
                }
                if (sum1+sum2<=threshold) {
                    count++;
                }
            }
        }
        return count;
    }
}
