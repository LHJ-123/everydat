public class Main4 {
    //把字符串转换成整数
    public int StrToInt(String str) {
        if (str == null||str.length() == 0) {
            return 0;
        }
        if ("+".equals(str)||"-".equals(str)) {
            return 0;
        }

        if (str.charAt(0) == '+'||str.charAt(0) == '-') {
            char x = str.charAt(0);;
            str = str.substring(1,str.length());
            if (str.matches("^[0-9]*$")) {
                int a = Integer.parseInt(str);
                if (a>=Integer.MIN_VALUE&&a<=Integer.MAX_VALUE) {
                    if (x == '+') {
                        return a;
                    }else {
                        String s = "-"+a;
                        int b = Integer.parseInt(s);
                        return b;
                    }
                }else {
                    return 0;
                }
            }
        }else {
            if (str.matches("^[0-9]*$")) {
                int a = Integer.parseInt(str);
                if (a>=Integer.MIN_VALUE&&a<=Integer.MAX_VALUE) {
                        return a;
                }else {
                    return 0;
                }
            }
        }

        return 0;
    }
}
