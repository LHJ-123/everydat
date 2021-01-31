public class Main {
    //翻转单词顺序列
    public String ReverseSentence(String str) {
        if (str == null||str.length() == 0||str.trim().equals("")) {
            return str;
        }


        String s = "";
        String[] arr = str.split(" ");
        for (int i = arr.length-1;i>=0;i--) {
            if (i == 0) {
                s+=arr[i];
            }else {
                s+=arr[i]+" ";
            }

        }
        return s;

    }
}
