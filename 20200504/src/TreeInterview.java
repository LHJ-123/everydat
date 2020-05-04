import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreeInterview {
    /*public static boolean backspaceCompare(String S, String T) {
        Stack<Character> A = new Stack<>();
        char[] a = S.toCharArray();
        for(char i:a ) {
            if(i =='#' ){
                if(A.empty()) {
                    continue;
                }
                A.pop();
                continue;
            }
            A.push(i);
        }
        Stack<Character> B = new Stack<>();
        char[] b = T.toCharArray();
        for(char i:b ) {
            if(i == '#'){
                if(B.empty()) {
                    continue;
                }
                B.pop();
                continue;
            }
            B.push(i);
        }
        if(A .equals(B) ) {
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        boolean x = backspaceCompare(S,T);
        System.out.println(x);
    }*/
    public boolean backspaceCompare(String S,String T) {
        Stack<Character> A = new Stack<>();
        char[] a = S.toCharArray();
        for (char i:a) {
            if (i == '#') {
                if (A.empty()) {
                    continue;
                }
                A.pop();
                continue;
            }
            A.push(i);
        }
        Stack<Character> B = new Stack<>();
        char[] b = T.toCharArray();
        for (char i:b) {
            if (i == '#') {
                if (B.empty()) {
                    continue;
                }
                B.pop();
                continue;
            }
            B.push(i);
        }
        if (A.equals(B)) {
            return true;
        }else {
            return false;
        }
    }
    public boolean isSameTree(TreeNode p,TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        return q.val == p.val && isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }
    public boolean isSubtree(TreeNode s,TreeNode t) {
        if (s == null) {
            return false;
        }
        isSameTree(s,t);
        isSubtree(s.left,t);
        isSubtree(s.right,t);
        return isSameTree(s,t) || isSubtree(s.left,t)
                || isSubtree(s.right,t);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
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
        return (leftDepth-rightDepth<=1&&leftDepth-rightDepth>=-1)
                &&isBalanced(root.left) && isBalanced(root.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left,root.right);
    }
    private boolean isMirror(TreeNode t1,TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isMirror(t1.left,t2.right)
                && isMirror(t1.right,t2.left);
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
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ((!queue.isEmpty())) {
            TreeNode cur = queue.poll();
            if (isFirstStep) {
                if (cur.left!=null&&cur.right!=null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if (cur.right!=null&&cur.left==null) {
                    return false;
                }else if (cur.left!=null&&cur.right==null) {
                    isFirstStep = false;
                    queue.offer(cur.left);
                }else {
                    isFirstStep = false;
                }
            }else {
                if (cur.left!=null||cur.right!=null) {
                    return false;
                }
            }
        }
        return true;
    }

}
