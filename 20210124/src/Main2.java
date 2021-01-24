
 class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Main2 {
    //树的子结构
    public boolean SameTree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && SameTree(root1.left,root2.left)
                && SameTree(root1.right,root2.right);
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return SameTree(root1,root2) || SameTree(root1.left,root2)
                || SameTree(root1.right,root2);
    }
}