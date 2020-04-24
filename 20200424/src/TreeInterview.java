import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class TreeInterview {

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

    public boolean isSubtree(TreeNode s,TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSameTree(s,t)||isSubtree(s.left,t)
                ||isSubtree(s.right,t);


    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1+(leftDepth>rightDepth?leftDepth:rightDepth);
    }
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right == null&&root.left == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth-rightDepth<=1&&leftDepth-rightDepth>=-1)
                &&isBalance(root.left)&&isBalance(root.right);
    }

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
        return t1.val == t2.val &&isMirror(t1.left,t2.right)
                &&isMirror(t1.right,t2.left);
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
            if (cur.left!= null) {
                queue.offer(root.left);
            }

            if (cur.right!= null) {
                queue.offer(root.right);
            }
        }

    }
//判断一个数是否为完全二叉树
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (isFirstStep) {
                if (cur.left != null&&cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.right != null && cur.left==null) {
                    return false;
                }else if (cur.left!=null&&cur.right == null) {
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
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.clear();
        levelOrderHelper(root,0);
        return result;
    }
    private void levelOrderHelper(TreeNode root,int level) {
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);
        if (root.left!=null) {
            levelOrderHelper(root.left,level+1);
        }
        if (root.right!=null) {
            levelOrderHelper(root.right,level+1);
        }
    }




}
