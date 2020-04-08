package array;

/**
 * @Author: zjumic
 * @Date: created at 21:10 2020/3/8
 */

// 一个数据先递增再递减，找出数组不重复的个数，比如 [1, 3, 9, 1]，结果为3，不能使用额外空间，复杂度o(n)
public class FindUnique {

    public int findUniqueCount(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        int count = 1;
        int last = nums[left];
        while (left <= right) {
            if (nums[left] == nums[right]) {
                if (nums[left] != last) {
                    count++;
                    last = nums[left];
                }
                left++;
                right--;
            } else {
                if (nums[left] < nums[right]) {
                    if (nums[left] != last) {
                        count++;
                        last = nums[left];
                    }
                    left++;
                } else {
                    if (nums[right] != last) {
                        count++;
                        last = nums[right];
                    }
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,2,2,2,1};
        FindUnique f = new FindUnique();
        System.out.println(f.findUniqueCount(nums));
    }
}
