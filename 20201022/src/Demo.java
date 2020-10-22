//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
public class Demo {
    public boolean isSame(TreeNode tree1,TreeNode tree2) {
        //小树为空，遍历完毕，是大树的一个子结构
        if(tree2 == null) {
            return true;
        }
        //大树遍历完，没有符合的子结构
        if(tree1 == null) {
            return false;
        }
        if(tree1.val != tree2.val) {
            return false;
        }
        return isSame(tree1.left,tree2.left)&&isSame(tree1.right,tree2.right);
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null) {
            return false;
        }
        return isSame(root1,root2) || isSame(root1.left,root2) || isSame(root1.right,root2);
    }
}