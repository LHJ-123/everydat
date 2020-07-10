import java.util.*;
//创建一个PCB类
class PCB {
    String name;
    int time;
    int BigNum;
    char cur;
//用构造方法初始化
    public PCB(String name, int time, int bigNum, char cur) {
        this.name = name;
        this.time = time;
        BigNum = bigNum;
        this.cur = cur;
    }


}
public class TestCpu {
    public static void main(String[] args) {
        //创建优先队列，并让他从大到小排列
        PriorityQueue<PCB> queue = new PriorityQueue<>(new Comparator<PCB>() {
            @Override
            public int compare(PCB o1, PCB o2) {
                return o2.BigNum-o1.BigNum;
            }
        });
        PCB pcb1 = new PCB("P1",2,1,'R');
        PCB pcb2 = new PCB("P2",3,5,'R');
        PCB pcb3 = new PCB("P3",1,3,'R');
        PCB pcb4 = new PCB("P4",2,4,'R');
        PCB pcb5 = new PCB("P5",4,2,'R');
        //将创建好的PCB实例加入队列
        queue.offer(pcb1);
        queue.offer(pcb2);
        queue.offer(pcb3);
        queue.offer(pcb4);
        queue.offer(pcb5);
        Queue<PCB> queue1 = new LinkedList<>();

        while (!queue.isEmpty()) {
            PCB pcb6 = queue.peek();
            System.out.println("被选中进程:"+pcb6.name);
            if(pcb6.time!=0) {
                pcb6.BigNum--;
                pcb6.time--;
            }else {
                pcb6.cur = 'E';
               queue1.offer(queue.poll());
            }
            System.out.println("进程块序列:");
            for (PCB pcb:queue) {
                System.out.print(pcb.name+" ");
            }
            System.out.println();
        }
        for (PCB pcb:queue1) {
            System.out.println(pcb.name+" "+pcb.time+" "+pcb.BigNum+" "+pcb.cur);
        }
    }

}
