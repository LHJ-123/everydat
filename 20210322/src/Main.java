import java.util.ArrayList;

public class Main {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length == 0||size>num.length||size<=0) {
            return list;
        }
        int max = 0;
        for (int i = 0;i<=num.length-size;i++) {
            max = num[i];
            for (int j = i;j<size+i;j++) {
                if (max<num[j]) {
                    max = num[j];
                }
            }
            list.add(max);
        }
        return list;
    }
}
