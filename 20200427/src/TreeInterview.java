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
    //线程不安全
private StringBuilder stringBuilder = new StringBuilder();
    //用前序遍历将二叉树转换成一个由括号和整数组成的字符串
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        helper(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();//访问类中内容

    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        helper(root.left);
        if (root.left == null&&root.right!=null) {
            stringBuilder.append("()");
        }
        helper(root.right);
        stringBuilder.append(")");
    }

    //先序遍历的非递归实现
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val+" ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    //中序遍历的非递归实现
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val+" ");
            cur = cur.right;

        }
    }

    //后序遍历的非递归实现
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.empty()) {
                break;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                System.out.println(top.val);
                stack.pop();
                prev = top;
            }else {
                cur = cur.right;
            }
        }
    }
}
