
public class ThreadTest {
    public static void main(String[] args) {
        String a = "sas";
        StringBuffer str1 = new StringBuffer();
        str1.append(a);
        StringBuffer str3 = new StringBuffer();
        StringBuffer str4 = new StringBuffer();
        for(int i=0;i < str1.length();i++) {

           str3.append(str1.charAt(i));
        }
        for(int i=str1.length()-1;i >=0;i--) {

            str4.append(str1.charAt(i));
        }
        System.out.println(str3);

        System.out.println(str4);
        System.out.println(str4.length());
        System.out.println(str3.equals(str4));
    }
}
