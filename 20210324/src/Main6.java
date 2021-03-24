public class Main6 {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return null;
        }
        if (pRoot.left == null&&pRoot.right == null) {
            return pRoot;
        }
        TreeNode node = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = node;
        if (pRoot.left!=null) {
            Mirror(pRoot.left);
        }
        if (pRoot.right!=null) {
            Mirror(pRoot.right);
        }
        return pRoot;
    }
}
