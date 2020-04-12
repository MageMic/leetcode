package array;

/**
 * @Author: zjumic
 * @Date: created at 16:59 2020/4/9
 */
// 修改一个数使数组成为非递减数组
// 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
//我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，总满足 array[i] <= array[i + 1]。
//
// 
//
//示例 1:
//
//输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/non-decreasing-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class NonDereasingArrayReplaceOnce {

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,3};
        System.out.println(checkPossibility(nums));
    }

    // 应当修改nums[i - 1] = nums[i],否则后面的数可能比i-1小
    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            cnt++;
            // 还有一种特殊情况，如果i < i - 2, 如果修改i - 1 = i, i - 2会比i大，所以修改i = i - 1
            if (i >= 2 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
