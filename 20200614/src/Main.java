import java.util.Scanner;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while(in.hasNext()) {
            set.add(in.next());
        }
        int count = set.size();
        System.out.println(count);
    }
}
