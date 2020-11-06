import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Demo2 {
    public static String getNum(int a,int b,int c,int d) {

        if (c == 0 && d == 0) {

            Set<Integer> set = new HashSet<>();
            Random random = new Random();

            while (set.size() != b) {
                set.add(random.nextInt(a));

            }
            return set.toString();
        }else {
            Set<Integer> set = new HashSet<>();
            Set<Integer> set1 = new HashSet<>();
            Random random = new Random();

            while (set.size() != b) {
                set.add(random.nextInt(a));
            }
            while ( set1.size() != d) {
                set1.add(random.nextInt(c));
            }
            for (Integer x:set1) {
              set.add(x);
            }
            return set.toString();
        }
    }
    public static void main(String[] args) {

        System.out.println("22选5: "+getNum(22,5,0,0));
        System.out.println("33选7: "+getNum(33,7,0,0));
        System.out.println("双色球: "+getNum(33,6,16,1));

    }
}
