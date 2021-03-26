public class Main5 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null||sequence.length == 0) {
            return false;
        }
        int cur = sequence.length-1;
        int count = 0;
        while (cur>0) {
            while (sequence[cur]>sequence[count]) {
                count++;
            }
            while (sequence[cur]<sequence[count]) {
                count++;
            }
            if (count!=cur) {
                return false;
            }
            cur--;
            count = 0;
        }
        return true;
    }
}
