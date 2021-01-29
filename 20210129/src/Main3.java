
  class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Main3 {
    //二叉树深度
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null&&root.right == null) {
            return 1;
        }
        return 1+(TreeDepth(root.right)>TreeDepth(root.left)?TreeDepth(root.right):TreeDepth(root.left));

    }
}