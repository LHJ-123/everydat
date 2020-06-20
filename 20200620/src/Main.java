import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count = in.nextInt();
        int num = 0;
        int ret = -1;
        String s1 = "";
        for(int i = 0;i<s.length();i++) {
            if(count+i>=s.length()) {
                break;
            }else {
                for(int j = i;j<count+i;j++) {
                    if(s.charAt(j) == 'G' || s.charAt(j) == 'C') {
                        num++;
                    }else {
                        continue;
                    }
                }
                if(num>ret) {
                    ret = num;

                    s1 = s.substring(i,i+count);
                }
                num = 0;
            }

        }
        System.out.println(s1);
    }
}