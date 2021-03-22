public class Main5 {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val+","+Serialize(root.left)+","+Serialize(root.right);

    }
    int index = -1;
    TreeNode Deserialize(String str) {
        String[] split = str.split(",");
        int length = split.length;
        index++;
        if (index>=length) {
            return null;
        }
        TreeNode treeNode = null;
        if (!split[index].equals("#")) {
            treeNode = new TreeNode(Integer.parseInt(split[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;

    }

}
