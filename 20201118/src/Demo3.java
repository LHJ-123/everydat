import java.util.*;

public class Demo3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0;i<a.length;i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        List<String> list = new ArrayList<>();
        for (int i = 0;i<a.length;i++) {
            if (a[i] == 1) {
                String s = "";
                s = s+a[i]+"->"+b[i];
                int cur = i;
                for (int j = i+1;j<a.length;j++) {
                    if (b[cur] == a[j]) {
                        s =s+ "->"+b[j];
                        cur++;
                        continue;
                    }else {
                        if (b[cur] == 1) {
                            list.add(s);
                            break;
                        }else {
                            break;
                        }
                    }
                }
                if (b[a.length-1] == 1) {
                    list.add(s);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
