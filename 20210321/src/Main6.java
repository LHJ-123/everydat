import java.util.ArrayList;

public class Main6 {
    ArrayList<TreeNode> list = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        inOrder(pRoot);
        if (k<1||k>list.size()) {
            return null;
        }
        return list.get(k-1);

    }

    private void inOrder(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        inOrder(pRoot.left);
        list.add(pRoot);
        inOrder(pRoot.right);
    }
}
