
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Main {
    //对称的二叉树
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

       return Synm(pRoot.left,pRoot.right);
    }

    private boolean Synm(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null&&rightRoot== null) {
            return true;
        }
        if (leftRoot == null||rightRoot == null) {
            return false;
        }
        if (leftRoot.val == rightRoot.val) {
            return Synm(leftRoot.left,rightRoot.right)&&Synm(leftRoot.right,rightRoot.left);
        }else {
            return false;
        }

    }
}