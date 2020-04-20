class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
public class TestTree {
    public  static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);

        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);

    }
   /* public static int treeSize = 0;
    public static void size(Node root) {
        if (root == null) {
            return;
        }
        treeSize++;
        size(root.left);
        size(root.right);
    }*/
//求结点个数
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
       return  1+size(root.left)+size(root.right);

    }
  /*  public static int leafSize = 0;
    public static void leafSize(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
            return;
        }
        leafSize(root.left);
        leafSize(root.right);
    }*/

//求叶子结点
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);

    }
    //求第K层结点个数
    public static int kLevelSize(Node root,int k) {
        if (root == null || k<1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left,k-1)+kLevelSize(root.right,k-1);


    }
    //寻找关键字为toFind的结点
   /* public static Node result = null;
    public static void find(Node root,char toFind) {
        if (root == null) {
            return;
        }
        if (root.val == toFind) {
            result = root;
            return;
        }
        find(root.left,toFind);
        find(root.right,toFind);
    }*/

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


    public static void main(String[] args) {
        Node root = build();
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        size(root);
        System.out.println();
       // System.out.println(treeSize);
        int size = size(root);
        System.out.println(size);
       int leafSize =  leafSize(root);
        System.out.println(leafSize);
       // System.out.println(leafSize);
        int ret = kLevelSize(root,3);
        System.out.println(ret);
        Node x = find(root,'F');
        System.out.println(x);
        //System.out.println(result);
    }
}
