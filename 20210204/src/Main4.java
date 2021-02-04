import java.util.ArrayList;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Main4 {
    //二叉树的下一个节点
    public ArrayList<TreeLinkNode> linkNodes = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode cur = pNode;
        while (cur.next!=null) {
            cur = cur.next;
        }
        InOrder(cur);
        for (int i = 0;i<linkNodes.size();i++) {
            if (pNode == linkNodes.get(i)) {
                return i == linkNodes.size()-1?null:linkNodes.get(i+1);
            }
        }
        return null;


    }

    private void InOrder(TreeLinkNode cur) {
        if (cur!=null) {
            InOrder(cur.left);
            linkNodes.add(cur);
            InOrder(cur.right);
        }
    }
}