class TreeNode {
    TreeNode right;
    TreeNode left;
}
public class Main3 {
    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        TreeNode n = root.left;
        root.left = root.right;
        root.right = n;
        Mirror(root.left);
        Mirror(root.right);
    }
}
