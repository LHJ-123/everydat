import java.util.ArrayList;

public class Main2 {
    //和为S的连续正数序列
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1;i<sum;i++) {
            int tmp = 0;
            int j = i;
            while (tmp<sum) {
                tmp+=j;
                j++;
            }
            if (tmp == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = i;k<j;k++) {
                    list.add(k);
                }
                result.add(list);
            }
        }
        return result;

    }
}
