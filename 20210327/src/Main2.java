import java.util.ArrayList;

class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Main2 {
    ArrayList<TreeNode> list = new ArrayList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inOrder(pRootOfTree);
        make(list);
        return list.get(0);
    }

    private void make(ArrayList<TreeNode> list) {
        for (int i = 1;i<list.size();i++) {
            list.get(i-1).right = list.get(i);
            list.get(i).left = list.get(i-1);
        }
    }

    private void inOrder(TreeNode pRootOfTree) {
        if (pRootOfTree!=null) {
            inOrder(pRootOfTree.left);
            list.add(pRootOfTree);
            inOrder(pRootOfTree.right);
        }
    }
}