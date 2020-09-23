package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zjumic
 * @Date: created at 21:31 2020/4/4
 */
// 下一个全排列的数
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,6,5,4};
        for (int i : nextPermutation1(nums)) {
            System.out.print(i + " ");
        }
    }

    // 思路1：从右往左，右边正序排列，
    // 如果当前值大于右边最大值，将当前值加入右侧排列，
    // 如果小于右侧最大值，则当前值与右侧第一个大于当前值的位置交换
    public static int[] nextPermutation1(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int n = nums.length;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[n - 1]) {
                for (int j = i; j < n - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            } else {
                int j = i + 1;
                while (j < n && nums[j] < nums[i]) {
                    j++;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                break;
            }
        }
        return nums;
    }

}
