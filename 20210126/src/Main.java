import java.util.ArrayList;

class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Main {
    //二叉树中和为某一值得路径
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        find(root,target,result,path);
        return result;

    }

    private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target-root.val;
        if (target<0) {
            return;
        }
        if (target == 0 && root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        find(root.left,target,result,new ArrayList<>(path));
        find(root.right,target,result,new ArrayList<>(path));
    }


}
