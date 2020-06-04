import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String ret = "";
        int count = 0;
        for(int i = 0;i<str.length();i++) {
            if(str.charAt(i)>='0'&&str.charAt(i)<='9') {
                int index = i;
                count = 1;
                for(int j=i+1;j<str.length();j++ ) {
                    if(str.charAt(j)>='0'&&str.charAt(j)<='9') {
                        count++;
                        index = j;
                    }else {

                        break;
                    }
                }
                if(count>ret.length()) {
                    ret = str.substring(i,index+1);
                }else {
                    continue;
                }
            }
        }
        System.out.println(ret);
    }
}
