//day44 1
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.next();
            String s1 = "";
            char[] arr = s.toCharArray();
            for(int i = 0;i<arr.length;i++) {

                if(arr[i] == '_') {
                  arr[i+1]= (char)(arr[i+1]-32);
                }
            }
            s1 = String.valueOf(arr);
            s1 = s1.replace("_","");
            System.out.println(s1);
        }
    }
}