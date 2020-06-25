import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main2 {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode result = new ListNode(-1);
        ListNode resultCur = result;
        //nextNum表示进位
        int nextNum = 0;
        while (a != null || b != null || nextNum != 0) {
            //获取两个链表里 的值从而进行相加
            int aval = (a != null)?a.val:0;
            int bval = (b != null)?b.val:0;
            //第一次的相加得出的进位要给第二次里加
            int sum = aval+bval+nextNum;
            //算出相加的产生的进位
            nextNum = sum/10;
            //算出要往新链表里加的值
            int realSum = sum%10;
            resultCur.next = new ListNode(realSum);
            resultCur = resultCur.next;
            //为第二次相加做准备
            a = a!=null?a.next:null;
            b = b!=null?b.next:null;
        }
        return result.next;
    }
}
