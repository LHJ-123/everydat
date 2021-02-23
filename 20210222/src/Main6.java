public class Main6 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null&&root.right == null) {
            return;
        }
        TreeNode tmp= root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);

    }
}
