import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            int[] array = new int[10];

            for(int i = 0;i<s.length();i++) {

                    if(s.charAt(i) == '0') {
                        array[0] ++;
                        continue;
                    }else if (s.charAt(i) == '1'){
                        array[1] ++;
                        continue;
                    }else if (s.charAt(i) == '2'){
                        array[2] ++;
                        continue;
                    }else if (s.charAt(i) == '3'){
                        array[3] ++;
                        continue;
                    }else if (s.charAt(i) == '4'){
                        array[4] ++;
                        continue;
                    }else if (s.charAt(i) == '5'){
                        array[5] ++;
                        continue;
                    }else if (s.charAt(i) == '6'){
                        array[6] ++;
                        continue;
                    }else if (s.charAt(i) == '7'){
                        array[7] ++;
                        continue;
                    }else if (s.charAt(i) == '8'){
                        array[8] ++;
                        continue;
                    }else {
                        array[9] ++;
                        continue;
                    }

            }
            int i = 0;
            for( i = 0;i<10;i++) {
                if(array[i] == 0) {
                    continue;
                }else {
                    System.out.println(i+":"+array[i]);
                }
            }
        }
    }

