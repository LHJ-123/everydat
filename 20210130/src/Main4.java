public class Main4 {
    //左旋字符串
    public String LeftRotateString(String str,int n) {
        if (str == null||str.length() == 0) {
            return "";
        }
        String s = "";
        s = str.substring(n,str.length())+str.substring(0,n);
        return s;

    }
}
