public class BinarySearchTree {
    static class Node {
        public int key;
        public int value;
        public Node left;
        public Node right;

        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node root = null;
    public Node find(int key) {
        Node cur = root;
        while (cur!=null) {
            if (key<cur.key) {
                cur = cur.left;
            }else if (key>cur.key){
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }
    public void

}
