class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TreeInterview {

    //找最近公共父节点
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
    private boolean findNode (TreeNode root,TreeNode p,TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = findNode(root.left,p,q)?1:0;
        int right = findNode(root.right,p,q)?1:0;
        int mid = (root == p||root == q)?1:0;
        if (left+right+mid == 2) {
            lca = root;
        }
       return (right+left+mid)>0;

    }
//将搜索二叉树中序遍历后转为链表返回
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null&&root.left == null) {
            return root;
        }
        TreeNode left = Convert(root.left);
        TreeNode leftTail = left;
        while (leftTail!=null&&leftTail.right!=null) {
            leftTail = leftTail.right;
        }
        if (leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }
        TreeNode right = Convert(root.right);
        if (right!=null) {
            root.right = right;
            right.left = root;
        }
        return left != null?left:root;
    }

//根据先序和中序结果构造二叉树
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
        if (index>=preorder.length) {
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



}
