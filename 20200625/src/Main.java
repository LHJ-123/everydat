//day22
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            while (in.hasNext()) {
                String s1 = in.next();
                String s2 = in.next();
                int count1 = 0;
                LinkedList<Character> list = new LinkedList<>();
                for(int i = 0;i<s1.length();i++) {
                    char ch = s1.charAt(i);
                    list.add(ch);
                }


                for(int i = 0;i<s2.length();i++) {
                    char x = s2.charAt(i);
                    for (int j = 0;j<list.size();j++) {
                        if (x == list.get(j)) {
                            list.remove(j);
                            count1++;
                            break;
                        }
                    }

                }
                if(count1 == s2.length()) {
                    System.out.println("Yes"+" "+(s1.length()-count1));
                }else {
                    System.out.println("No"+" "+(s2.length()-count1));
                }
            }


        }
}
