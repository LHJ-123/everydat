import java.util.Scanner;

public class Main4 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = scanner.nextInt();
            if (n>100) {
                return;
            }
            int index = (n-1)*n-1;
            String s = "";
            for (int i = 0;i<n;i++) {
                if (i!=n-1) {
                    s =s+(index+2)+"+";
                    index = index+2;
                }else {
                    s = s+(index+2);
                }
            }
            System.out.println(s);
        }

    }


}
