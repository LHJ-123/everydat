import java.util.Comparator;
import java.util.PriorityQueue;


// 标准库中的优先队列默认为小堆

public class TestPriorityQueue {
//自定义优先级
    static class MyComp implements Comparator<Integer> {
        public int compare(Integer o1,Integer o2) {

            return o2-o1;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new MyComp());
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.println(cur);
        }

    }
}
