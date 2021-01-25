public class Main4 {
    //二叉搜索树的后序遍历序列
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0||sequence == null) {
            return false;
        }
        int root = sequence.length-1;
        int count = 0;
        while (root>0) {
            while (sequence[root]>sequence[count]) {
                count++;
            }
            while (sequence[root]<sequence[count]) {
                count++;
            }
            if (count<root) {
                return false;
            }
            root--;
            count = 0;
        }
        return true;

    }
}
