import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class TestTree {

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1+size(root.left)+size(root.right);

    }

    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left)+leafSize(root.right);
    }

    public static int kLevelSize(Node root,int k) {
        if (root == null && k<1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left,k-1)+kLevelSize(root.right,k-1);

    }

    public static Node find(Node root,int toFind) {
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
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;

    }


}
