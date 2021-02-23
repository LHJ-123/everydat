
  class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Main5 {
    public boolean isSame(TreeNode root1,TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return true;
        }
        return isSame(root1.left,root2.left)
                &&isSame(root1.right,root2.right);
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null||root2 == null) {
            return false;
        }

        return isSame(root1,root2)&&isSame(root1.left,root2)
                &&isSame(root1.right,root2);

    }
}

