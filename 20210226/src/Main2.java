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
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(pRootOfTree,list);
        return made(list);
    }

    private TreeNode made(ArrayList<TreeNode> list) {
        for (int i = 0;i<list.size()-1;i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }

    private void inOrder(TreeNode pRootOfTree, ArrayList<TreeNode> list) {
        if (pRootOfTree == null) {
            return;
        }
        if (pRootOfTree.left!=null) {
            inOrder(pRootOfTree.left,list);
        }
        list.add(pRootOfTree);
        if (pRootOfTree.right!=null) {
            inOrder(pRootOfTree.right,list);
        }

    }
}