public class Main6 {
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
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right == null&&root.left == null) {
            return true;
        }
        int leftLenfth = TreeDepth(root.left);
        int rightLenfth = TreeDepth(root.right);
        return (rightLenfth-leftLenfth<=1&&rightLenfth-leftLenfth>=-1)
                &&IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);


    }
}
