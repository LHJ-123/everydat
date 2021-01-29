import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        String s = "123";
        System.out.println(s);
        int n = Integer.parseInt(s);
        //System.out.println(n);
        //String s1 = String.valueOf(n);
        //System.out.println(s1);
        int[] arr = {1,2,3,4};
        String s1 = Arrays.toString(arr);
        s1 = s1.replace("[","");
        s1 = s1.replace("]","");
        s1 = s1.replace(" ","");
        System.out.println(s1);
        s1 = s1.replace(",","");
        //System.out.println(s1);


    }
}
