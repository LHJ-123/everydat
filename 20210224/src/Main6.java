import java.util.ArrayList;

public class Main6 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        find(root,target,path,result);
        return result;
    }

    private void find(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target-root.val;
        if (target<0) {
            return;
        }
        if (target == 0&&root.left == null&&root.right == null) {
            result.add(path);
            return;
        }
        find(root.left,target,new ArrayList<>(path),result);
        find(root.right,target,new ArrayList<>(path),result);
    }
}

