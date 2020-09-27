//找出出现一次的数字
public class Demo1 {
    public static boolean cur = true;
    public  int findOneNum(int[] num) {
        int i1 = num.length;
        int i = 0;
        int j = 0;
        for (i = 0;i<i1;i++) {
            for ( j = i+1;j<i1;j++) {
                if (num[i] == num[j]) {
                    int tmp = num[j];
                    num[j] = num[i1-1];
                    num[i1-1] = tmp;
                     i1 = i1-1;
                    cur = false;
                    break;
                }
            }
            if (cur == true) {
                return num[i];
            }
           cur = true;
        }
        return -1;
    }

   /* public static void main(String[] args) {
        int[] array = {3,2,6,3,1,9,2,6,1};
        int ret = findOneNum(array);
        System.out.println(ret);
    }*/
}
