class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
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

    public static void midOrder(Node root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.print(root.val);

        midOrder(root.right);
    }

    public static void nextOrder(Node root) {
        if (root == null) {
            return;
        }
        nextOrder(root.left);
        nextOrder(root.right);
        System.out.print(root.val);

    }

    public static void main(String[] args) {
        Node root = build();
        preOrder(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        nextOrder(root);
    }
}
