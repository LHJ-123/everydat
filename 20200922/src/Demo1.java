public class Demo1 {
    public  void flipStr(String s) {
        String[] str = s.split(" ");
        for (int i = str.length-1;i>=0;i--) {
            System.out.print(str[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }

    /*public static void main(String[] args) {
        String s = "I am a student";
        flipStr(s);
    }*/
}
