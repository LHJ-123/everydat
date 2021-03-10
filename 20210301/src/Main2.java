import java.util.ArrayList;

public class Main2 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i = 0;
        int j = array.length-1;
        ArrayList<Integer> list = new ArrayList<>();

        while (i<=j) {
            if (array[i]+array[j]<sum) {
                i++;
                continue;
            }
            while (array[i]+array[j]>sum) {
                j--;
            }
            if (array[i]+array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
            i++;
        }
        return list;

    }
}
