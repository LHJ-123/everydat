class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class Demo {
    //求节点个数
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1+size(root.right)+size(root.left);
    }

    //求叶子节点
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return leafSize(root.left)+leafSize(root.right);
    }

    //求第K层节点个数
    public static int kLevelSize(Node root,int k) {
        if (root == null || k<1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left,k-1)+kLevelSize(root.right,k-1);

    }

    //寻找关键字为toFind的节点
    public static Node find(Node root,char toFind) {
        if (root == null) {
            return null;
        }
        if (root.val == toFind) {
            return root;
        }
        Node result = null;
        result = find(root.left,toFind);
        if (result != null) {
            return result;
        }
        return find(root.right,toFind);
    }
}



