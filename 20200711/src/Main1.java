import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
       while (!queue.isEmpty()) {
           Integer x = queue.poll();
           System.out.println(x);
       }
    }
}
