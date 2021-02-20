import java.util.Arrays;

public class Main {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0;i<nums.length;i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
