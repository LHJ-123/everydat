import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeInterview {
/*    public static boolean backspaceCompare(String S, String T) {
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
        if(A == B) {
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
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
//判断两个树是否相同

public boolean isSameTree(TreeNode p,TreeNode q) {
    if(p == null && q == null) {
        return true;
        //都是空树，也为相等
    }
    if (q == null || p == null) {
        return false;
    }
    return (p.val == q.val)&&(isSameTree(p.left,q.left))
            &&(isSameTree(p.right,q.right));


}

    //判定s中是否包含t
public boolean isSubtree(TreeNode s,TreeNode t) {
    //遍历这个树，访问某个结点时，用判断是否相同的函数去判断

    if (s == null) {
        return false;
    }
    isSameTree(s,t);
    isSubtree(s.left,t);
    isSubtree(s.right,t);
    return isSameTree(s,t) || isSubtree(s.right,t)
            || isSubtree(s.left,t);
//判定是否包含，只需判断是否一样，或者左子树是否包含或者右子树是否包含
}

//求二叉树深度

public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    if (root.left == null&&root.right == null) {
        return 1;
    }
    return 1+(maxDepth(root.left)>maxDepth(root.right)?maxDepth(root.left):maxDepth(root.right));

}

//判断是否为平衡二叉树
    public boolean isBalanced(TreeNode root) {
    if (root == null) {
        return true;
    }
    if (root.left == null&&root.right == null) {
        return true;
    }
     int leftDepth = maxDepth(root.left);
     int rightDepth = maxDepth(root.right);
     return (leftDepth-rightDepth<=1&&leftDepth-rightDepth>=-1)
             &&isBalanced(root.left)&&isBalanced(root.right);



    }

    //判定是否为镜像对称二叉树
    public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }
    return isMirror(root.left,root.right);


    }
    private boolean isMirror(TreeNode t1,TreeNode t2) {
    if (t1 == null&&t2 == null) {
        return true;
    }
    if (t1 == null||t2 == null) {
        return false;
    }
    return t1.val == t2.val && isMirror(t1.left ,t2.right)
            && isMirror(t1.right,t2.left);
    }

    //层序遍历
public void levelOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
while (!queue.isEmpty()) {
    TreeNode cur = queue.poll();
    System.out.print(cur.val);
    if (cur.left!=null) {
        queue.offer(cur.left);
    }
    if (cur.right!=null) {
        queue.offer(cur.right);
    }
}
}



}
