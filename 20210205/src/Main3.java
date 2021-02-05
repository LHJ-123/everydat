import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main3 {
    //把二叉树打印成多行
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()||!queue1.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode pop = queue.poll();
                list1.add(pop.val);
                if (pop.left!=null) {
                    queue1.add(pop.left);
                }
                if (pop.right!=null) {
                    queue1.add(pop.right);
                }
            }
            if (list1.size()!=0) {
                result.add(list1);
            }
            while (!queue1.isEmpty()) {
                TreeNode pop = queue1.poll();
                list2.add(pop.val);
                if (pop.left!=null) {
                    queue.add(pop.left);
                }
                if (pop.right!=null) {
                    queue.add(pop.right);
                }
            }
            if (list2.size()!=0) {
                result.add(list2);
            }

        }
        return result;
    }
}
