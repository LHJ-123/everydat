import java.util.Scanner;
/*class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}*/
public class BuildTree {
public static int index = 0;
    public static TreeNode buildTree(String line) {
        char ch = line.charAt(index);
        if (ch == '#') {
            return null;
        }
        TreeNode node = new TreeNode(ch);
        index++;
        node.left = buildTree(line);
        index++;
        node.right = buildTree(line);
        return node;
    }
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);

        inOrder(root.right);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            index = 0;//为的是处理多组输入时，index初始值为0
            TreeNode root = buildTree(line);
            inOrder(root);
            System.out.println();
        }
    }
}
