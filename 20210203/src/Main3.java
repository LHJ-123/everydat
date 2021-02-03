import java.util.ArrayList;

public class Main3 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<length;i++) {
            if (list.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }else {
                list.add(numbers[i]);
            }
        }
        return false;

    }
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
             if (numbers == null||numbers.length == 0) {
                 return false;
             }
             for (int i = 0;i<length;i++) {
                 while (numbers[i] != i) {
                     if (numbers[i] == numbers[numbers[i]]) {
                         duplication[0] = numbers[i];
                         return true;
                     }
                     int tmp = numbers[i];
                     numbers[i] = numbers[tmp];
                     numbers[tmp] = tmp;
                 }
             }
             return false;

    }
}
