
  class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Main5 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null&&root.right == null) {
            return 1;
        }
        int leftDept = TreeDepth(root.left);
        int rightDept = TreeDepth(root.right);
        return 1+(leftDept>rightDept?leftDept:rightDept);

    }
}