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

public class Main {
    ArrayList<TreeLinkNode> linkNodes = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode cur = pNode;
        while (cur.next!=null) {
            cur = cur.next;
        }
        inOrder(cur);
        for (int i = 0;i<linkNodes.size();i++) {
            if (pNode == linkNodes.get(i)) {
                return i == linkNodes.size()-1?null:linkNodes.get(i+1);
            }
        }
        return null;
    }

    private void inOrder(TreeLinkNode cur) {
        if (cur!=null) {
            inOrder(cur.left);
            linkNodes.add(cur);
            inOrder(cur.right);
        }
    }
}