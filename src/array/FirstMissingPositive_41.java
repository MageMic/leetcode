package array;

/**
 * @Author: zjumic
 * @Date: created at 21:07 2020/3/24
 */
// 第一个没有出现的正整数
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean contains1 = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                contains1 = true;
                break;
            }
        }
        if (!contains1) {
            return 1;
        } else if (n == 1) {
            return 2;
        }
        // 因为第一个没出现的整数一定小于n，所以把负数和大于n的都替换成1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        // 把a位索引的值置为相反数负数
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }
        //
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return n;
        }
        return n + 1;
    }
}
