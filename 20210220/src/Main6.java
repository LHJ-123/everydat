
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Main6 {
    public int index = 0;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        index = 0;
       return buildHelp(pre,in,0,in.length);
    }

    private TreeNode buildHelp(int[] pre, int[] in, int inLeft, int inRight) {
        if (inLeft>=inRight) {
            return null;
        }
        if (index>=in.length) {
            return null;
        }
        TreeNode node = new TreeNode(pre[index]);
        index++;
        int i = find(in,inLeft,inRight,node.val);
        node.left = buildHelp(pre,in,inLeft,i);
        node.right = buildHelp(pre,in,i+1,inRight);
        return node;
    }

    private int find(int[] in, int inLeft, int inRight, int val) {
        for (int i = inLeft;i<inRight;i++) {
            if (in[i] == val) {
                return i;
            }
        }
        return -1;
    }
}