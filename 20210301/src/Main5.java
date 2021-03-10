import java.util.Arrays;

public class Main5 {
    public boolean IsContinuous(int [] numbers) {
        if (numbers == null||numbers.length == 0||numbers.length>5) {
            return false;
        }
        Arrays.sort(numbers);
        int count = 0;
        int x = 0;
        for (int i = 0;i<numbers.length-1;i++) {
            if (numbers[i] == 0) {
                count++;
            }else {
                x = numbers[i+1]-numbers[i]-1;
                if (x>count||x<0) {
                    return false;
                }else {
                    count = count-x;
                }
            }
        }
        return true;
    }
}
