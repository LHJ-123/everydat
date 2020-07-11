import java.util.*;
//用一个类去描述空闲说明表
class Table {
    int location;
    int length;
    String cur;

    public Table(int location, int length, String cur) {
        this.location = location;
        this.length = length;
        this.cur = cur;
    }

    @Override
    public String toString() {
        return "Table{" +
                "起址=" + location +
                ", 长度=" + length +
                ", 状态='" + cur + '\'' +
                '}';
    }
}
public class TestMainStore {
    public static void main(String[] args) {
        Table table = new Table(0,512,"未分配");
        System.out.println("空闲区说明表:");
        System.out.println(table.toString());
        //定义优先队列，定义比较器按起址大小排列以实现最先适应算法
        PriorityQueue<Table> queue = new PriorityQueue<>(new Comparator<Table>() {
            @Override
            public int compare(Table o1, Table o2) {
                return o1.location-o2.location;
            }
        });
        queue.offer(table);
        Map<String,String> map = new HashMap<>();
        map.put("主存区",table.location+"->"+table.length);
        System.out.println("主存分区情况:");
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        PriorityQueue<Map<String,String>> queue1 = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int count = 8;
        while (count>0) {
            System.out.println("请输入要进行的操作:");
            String request1 = scanner.next();
            System.out.println("请输入要操作的空间大小:");
            int requestSize = scanner.nextInt();
            System.out.println("请输入任务名:");
            String request = scanner.next();
            if (request1.equals("申请")) {
                Queue<Table> queue3 = new LinkedList<>();
                Table table1 = null;
                for (Table x:new PriorityQueue<Table>(queue)) {
                    if((x.cur).equals("未分配")) {
                        if (x.length>=requestSize) {
                            Table table2 = queue.poll();
                             table1 = new Table(table2.location,requestSize,"已分配");
                             map.put(request,table1.location+"->"+(table1.location+requestSize));
                            Table table3 = new Table(table2.location+requestSize,table2.length-requestSize,"未分配");
                            queue.offer(table1);
                            queue.offer(table3);
                        }else {
                            queue3.offer(queue.poll());
                        }
                    }else {
                        queue3.offer(queue.poll());
                    }
                }
                for (Table x:new LinkedList<Table>(queue3)) {

                    queue.offer(queue3.poll());
                }
                System.out.println("===========");
                System.out.println("空闲区说明表:");

                while(!queue.isEmpty()) {
                    Table x = queue.poll();
                    queue3.offer(x);
                    System.out.println(x.toString());
                }
                for (Table x:queue3) {
                    queue.offer(x);
                }
                System.out.println("===========");
                System.out.println("主存分区情况:");
                for (Map.Entry<String,String> entry:map.entrySet()) {
                    System.out.println(entry.getKey()+":"+entry.getValue());
                }
                System.out.println("===========");
            }else {
                Queue<Table> queue4 = new LinkedList<>();
                for (Table x:new PriorityQueue<Table>(queue)) {
                    if ((x.cur).equals("已分配")&&x.length == requestSize) {
                        Table table2 = queue.poll();
                        Table table1 =new Table(table2.location,table2.length,"未分配");
                        queue.offer(table1);
                    }else {
                        queue4.offer(queue.poll());
                    }
                }
                for (Table x:new LinkedList<Table>(queue4)) {
                    queue.offer(queue4.poll());
                }

               Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
               while (iterator.hasNext()) {
                   Map.Entry<String,String> entry = iterator.next();
                   if ((entry.getKey()).equals(request)) {
                       iterator.remove();
                   }
               }
                System.out.println("===========");
                System.out.println("空闲区说明表:");
                while(!queue.isEmpty()) {
                    Table x = queue.poll();
                    queue4.offer(x);
                    System.out.println(x.toString());
                }
                for (Table x:queue4) {
                    queue.offer(x);
                }
                System.out.println("===========");
                System.out.println("主存分区情况:");
                for (Map.Entry<String,String> entry:map.entrySet()) {
                    System.out.println(entry.getKey()+":"+entry.getValue());
                }
                System.out.println("===========");
            }
            count--;
        }
    }
}
