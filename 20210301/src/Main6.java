import java.util.ArrayList;

public class Main6 {
    public int LastRemaining_Solution(int n, int m) {
        if (n<=0||m<1) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<n;i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size()>1) {
            index = (index+m-1)%list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
