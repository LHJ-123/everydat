import java.util.Arrays;
import java.util.Stack;

public class Main {
    //数组中只出现一次的数字
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i<array.length;i++) {
            if (stack.empty() || stack.peek()!=array[i]) {
                stack.push(array[i]);
            }else if (stack.peek() == array[i]) {
                stack.pop();
            }
        }
        num1[0] = stack.pop();
        num2[0] = stack.pop();

    }
}
