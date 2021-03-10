import java.util.ArrayList;

public class Main {

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
                for (int n = i;n<j;n++) {
                    list.add(n);
                }
                result.add(list);
            }
        }
        return result;

    }
}
