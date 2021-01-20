 //重建二叉树
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Main {
    int index = 0;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        index = 0;
        return reConstructBinaryTreeHelp(pre,in,0,in.length);

    }

    private TreeNode reConstructBinaryTreeHelp(int[] pre, int[] in, int inorderLeft, int inorderRight) {
        if (inorderLeft>=inorderRight) {
            return null;
        }
        if(index>=pre.length) {
            return null;
        }
        TreeNode node = new TreeNode(pre[index]);
        index++;
        int pos = find(in,inorderLeft,inorderRight,node.val);
        node.left = reConstructBinaryTreeHelp(pre,in,inorderLeft,pos);
        node.right = reConstructBinaryTreeHelp(pre,in,pos+1,inorderRight);
        return node;
    }

    private int find(int[] in, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft;i<inorderRight;i++) {
            if (in[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
