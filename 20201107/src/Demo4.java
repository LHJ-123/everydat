class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Demo4 {
    public int index = 0;
    public TreeNode buildTree(int[] pre,int[] order) {
        return buildTreeHelper(pre,order,0,order.length);
    }

    private TreeNode buildTreeHelper(int[] pre, int[] order, int leftOrder, int rightOrder) {
        if (leftOrder>=rightOrder) {
            return null;
        }
        if (index>=pre.length) {
            return null;
        }
        TreeNode node = new TreeNode(pre[index]);
        int pos = find(order,leftOrder,rightOrder,node.val);
        index++;
        node.left = buildTreeHelper(pre,order,leftOrder,pos);
        node.right = buildTreeHelper(pre,order,pos+1,rightOrder);
        return node;

    }

    private int find(int[] order, int leftOrder, int rightOrder, int val) {
        for (int i = leftOrder;i<rightOrder;i++) {
            if (order[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
