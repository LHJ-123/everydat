public class Main3 {
    public int StrToInt(String str) {
        if (str == null||str.length() == 0) {
            return 0;
        }
        if ("+".equals(str)||"-".equals(str)) {
            return 0;
        }
        if (str.charAt(0) == '+'||str.charAt(0) == '-') {
            char x = str.charAt(0);
            str = str.substring(1,str.length());
            if (str.matches("^[0-9]*$")) {
                int a = Integer.parseInt(str);
                if (a>=Integer.MIN_VALUE&&a<=Integer.MAX_VALUE) {
                    if (x == '-') {
                        str = "-"+str;
                        a = Integer.parseInt(str);
                        return a;
                    }else {
                        return a;
                    }
                }else {
                    return 0;
                }
            }else {
                return 0;
            }
        }else {
            if (str.matches("^[0-9]*$")) {
                int a = Integer.parseInt(str);
                if (a>=Integer.MIN_VALUE&&a<=Integer.MAX_VALUE) {
                        return a;
                    }else {
                    return 0;
                }
            }else {
                return 0;
            }
        }
    }
}
