import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Demo7 {
    public boolean isSameTree(TreeNode p,TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val &&isSameTree(p.left,q.left)
                &&isSameTree(p.right,q.right);
    }

    public boolean isSubTree(TreeNode p,TreeNode q) {
        if (p == null) {
            return false;
        }
        return isSameTree(p,q) || isSubTree(p.left,q)
                || isSubTree(p.right,q);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return 1+(maxDepth(root.left)>maxDepth(root.right)?maxDepth(root.left):maxDepth(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth-rightDepth<=1 && leftDepth-rightDepth>=-1)&&isBalanced(root.left)
                && isBalanced(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null&&t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return true;
        }
        return t1.val == t2.val && isMirror(t1.right,t2.left)
                && isMirror(t1.left,t2.right);
    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
}
