import javax.sql.DataSource;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Main {
    int index = -1;
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val+","+Serialize(root.left)+","+Serialize(root.right);


    }
    TreeNode Deserialize(String str) {
        String[] s = str.split(",");
        index++;
        int len = s.length;
        if (index>len) {
            return null;
        }
        TreeNode treeNode = null;
        if (!s[index].equals("#")) {
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;

    }
}