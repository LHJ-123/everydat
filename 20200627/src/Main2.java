class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null&&root.right == null) {
            return 1;
        }
        return 1+(maxDepth(root.left)>maxDepth(root.right)?maxDepth(root.left):maxDepth(root.right));

    }

    //判断是否为平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null&&root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth-rightDepth<=1&&leftDepth-rightDepth>=-1)
                &&isBalanced(root.left)&&isBalanced(root.right);



    }

}
