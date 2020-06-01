import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String a = scanner.next();
            String b = scanner.next();
            int cur = 1;
            int count = 0;
            while(cur<=a.length()+1) {
                StringBuffer str1 = new StringBuffer();
                StringBuffer str2 = new StringBuffer();
                str1.append(a);
                str2.append(b);
                if(cur == 1) {
                    str2.append(str1);
                    StringBuffer str3 = new StringBuffer();
                    StringBuffer str4 = new StringBuffer();
                    for(int i=0;i < str2.length();i++) {
                        str3.append(str2.charAt(i));
                    }
                    for(int i=str2.length()-1;i >=0;i--) {
                        str4.append(str2.charAt(i));
                    }
                    String t1 = str3.toString();
                    String t2 = str4.toString();
                    if(t1.equals(t2)) {
                        count = count+1;
                        cur = cur+1;
                        continue;
                    }else {
                        cur = cur+1;
                        continue;
                    }
                }else if(cur == a.length()+1) {
                    str1.append(str2);
                    StringBuffer str3 = new StringBuffer();
                    StringBuffer str4 = new StringBuffer();
                    for(int i=0;i < str1.length();i++) {
                        str3.append(str1.charAt(i));
                    }
                    for(int i=str1.length()-1;i >=0;i--) {
                        str4.append(str1.charAt(i));
                    }
                    String t1 = str3.toString();
                    String t2 = str4.toString();
                    if(t1.equals(t2)) {
                        count = count+1;
                        cur = cur+1;
                        continue;
                    }else {
                        cur = cur+1;
                        continue;
                    }
                }else {
                    StringBuffer str5 = new StringBuffer();
                    str5.append(str1.substring(0,cur-1));
                    str5.append(str2);
                    str5.append(str1.substring(cur-1,a.length()));
                    StringBuffer str3 = new StringBuffer();
                    StringBuffer str4 = new StringBuffer();
                    for(int i=0;i < str5.length();i++) {
                        str3.append(str5.charAt(i));
                    }
                    for(int i=str5.length()-1;i >=0;i--) {
                        str4.append(str5.charAt(i));
                    }
                    String t1 = str3.toString();
                    String t2 = str4.toString();
                    if(t1.equals(t2)) {
                        count = count+1;
                        cur = cur+1;
                        continue;
                    }else {
                        cur = cur+1;
                        continue;
                    }
                }
            }
            System.out.println(count);
        }
    }

