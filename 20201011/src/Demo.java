/*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
        例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/

//重建二叉树
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


public class Demo {
    public int index = 0;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return buildTreeHelper(pre,in,0,in.length);
    }
    public TreeNode buildTreeHelper(int[] pre,int[] in,int inLeft,int inRight) {
        if(inLeft>=inRight) {
            return null;
        }
        if(index>=in.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(pre[index]);
        index++;
        int pos = find(in,inLeft,inRight,newNode.val);
        newNode.left = buildTreeHelper(pre,in,inLeft,pos);
        newNode.right = buildTreeHelper(pre,in,pos+1,inRight);
        return newNode;
    }
    public int find(int[] in,int inLeft,int inRight,int val) {
        for(int i = inLeft;i<inRight;i++) {
            if(in[i] == val) {
                return i;
            }
        }
        return -1;
    }
}