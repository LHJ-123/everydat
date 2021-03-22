import java.util.ArrayList;
import java.util.Stack;

public class Main3 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        while (!stack1.empty()||!stack2.empty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            while (!stack1.empty()) {
                TreeNode pop = stack1.pop();
                list1.add(pop.val);
                if (pop.left != null) {
                    stack2.push(pop.left);
                }
                if (pop.right != null) {
                    stack2.push(pop.right);
                }
            }
            if (list1.size() != 0) {
                lists.add(list1);
            }
            while (!stack2.empty()) {
                TreeNode pop = stack2.pop();
                list2.add(pop.val);
                if (pop.right != null) {
                    stack1.push(pop.right);
                }
                if (pop.left != null) {
                    stack1.push(pop.left);
                }
            }
            if (list2.size() != 0) {
                lists.add(list2);
            }
        }
        return lists;
    }

}
