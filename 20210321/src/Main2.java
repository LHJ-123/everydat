
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Main2 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return Symmetrical(pRoot.left,pRoot.right);
    }

    private boolean Symmetrical(TreeNode left, TreeNode right) {
        if (left == null&&right == null) {
            return true;
        }
        if (left == null||right == null) {
            return false;
        }
        return left.val == right.val  &&
                Symmetrical(left.left ,right.right) &&
                Symmetrical(left.right,right.left);

    }
}