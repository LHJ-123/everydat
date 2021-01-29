public class Main4 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null&&root.right == null) {
            return 1;
        }
        return 1+(TreeDepth(root.right)>TreeDepth(root.left)?TreeDepth(root.right):TreeDepth(root.left));

    }
    //平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right == null&&root.left == null) {
            return true;
        }
        int leftLength = TreeDepth(root.left);
        int rightLength = TreeDepth(root.right);
        return (leftLength-rightLength<=1&&leftLength-rightLength>=-1)
                &&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);


    }
}
