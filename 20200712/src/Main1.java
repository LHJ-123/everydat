//day 36 2
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.next();
            String s1 = s.substring(2);
            char[] array = s1.toCharArray();
            double sum = 0;
            for(int i = 0;i<array.length;i++) {
                if (array[i]>='A'&&array[i]<='F') {
                    //array[i]-55得出的刚好是十六进制下该字符对应的值，再将其转换为整型进行运算
                    sum = sum+(Integer.valueOf(array[i]-55))*Math.pow(16,array.length-1-i);
                }else {
                    //array[i]-48得出的刚好是输入的该字符的字面整型值，再将其转换为整型进行运算
                    sum = sum+(Integer.valueOf(array[i]-48))*Math.pow(16,array.length-1-i);
                }
            }
            int sum1 = (int)sum;
            System.out.println(sum1);
        }
    }
}