//day 36 1
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] array = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });

        for (char x:array) {
            if (x>='A'&&x<='Z') {
                Integer count = map.get(x);
                if(count == null) {
                    map.put(x,1);
                    queue.offer(x);
                }else {
                    map.put(x,count+1);
                }
            }
        }
        Queue<Character> queue1 = new LinkedList<>();
        for (char w = 'A';w<='Z';w++) {
           if (queue.peek() == null) {
               queue.offer(w);
           }else {
               if (queue.peek() == w) {
                   queue1.offer(queue.poll());
                   continue;
               }else {
                   queue.offer(w);
                   queue1.offer(queue.poll());
                   continue;
               }
           }
        }
        for (char x:queue1) {
            queue.offer(x);
        }
       for (char x:new PriorityQueue<Character>(queue)) {
           if (map.get(x) == null) {
               map.remove(x);
               map.put(x,0);
           }
       }
        while (!queue.isEmpty()) {
            char a = queue.poll();
            System.out.println(a+":"+map.get(a));
        }
    }
}
