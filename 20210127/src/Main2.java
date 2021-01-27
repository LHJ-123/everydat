import java.util.ArrayList;

public class Main2 {
    //最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k>input.length) {
            return list;
        }
        quick(input);
        for (int i = 0;i<k;i++) {
            list.add(input[i]);
        }
        return list;

    }

    private void quick(int[] input) {
        quickHelp(input,0,input.length-1);
    }

    private void quickHelp(int[] input, int left, int right) {
        if (right<=left) {
            return;
        }
        int index = partition(input,left,right);
        quickHelp(input,left,index-1);
        quickHelp(input,index+1,right);
    }

    private int partition(int[] input, int left, int right) {
        int value = input[right];
        int cur1 = left;
        int cur2 = right;
        while (cur2>cur1) {
            while (cur2>cur1 && input[cur1]<= value) {
                cur1++;
            }
            while (cur2>cur1 && input[cur2]>=value) {
                cur2--;
            }
            if (cur2>cur1) {
                int tmp = input[cur1];
                input[cur1] = input[cur2];
                input[cur2] = tmp;
            }
        }
        int m = input[cur1];
        input[cur1] = input[right];
        input[right] = m;
        return cur1;
    }
}
