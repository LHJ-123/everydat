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
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
    private boolean findNode(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = findNode(root.left,p,q)?1:0;
        int right = findNode(root.right,p,q)?1:0;
        int mid = (root == p || root == q)?1:0;
        if (left+right+mid == 2) {
            lca = root;
        }
        return (right+left+mid)>0;
    }
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        TreeNode left = Convert(root.left);
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }
        TreeNode right = Convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left != null?left:root;
    }
    private int index = 0;
    public TreeNode buildTree(int[] preorder,int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }
    private TreeNode buildTreeHelper(int[] preorder,int[] inorder,
                                     int inorderLeft,int inorderRight) {
        if (inorderLeft>=inorderRight) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[index]);
        int pos = find(inorder,inorderLeft,inorderRight,newNode.val);
        index++;
        newNode.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
        newNode.right = buildTreeHelper(preorder,inorder,pos+1,inorderRight);
        return newNode;
    }
    private int find(int[] inorder,int inorderLeft,int inorderRight,int val) {
        for (int i = inorderLeft;i<inorderRight;i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        helper(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        helper(root.left);
        if (root.left == null && root.right != null) {
            stringBuilder.append("()");
        }
        helper(root.right);
        stringBuilder.append(")");
    }
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            System.out.println(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }
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
            System.out.println(top.val);
            cur = cur.right;
        }
    }
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
