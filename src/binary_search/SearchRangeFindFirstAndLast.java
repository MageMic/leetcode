package binary_search;

/**
 * @Author: zjumic
 * @Date: created at 21:52 2020/3/23
 */

// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//
//如果数组中不存在目标值，返回 [-1, -1]。
//
//示例 1:
//
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//示例 2:
//
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class SearchRangeFindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        int left = leftBound(nums, target);
        if (left == nums.length || nums[left] != target) {
            return result;
        }
        int right = rightBound(nums, target);
        result[0] = left;
        result[1] = right;
        return result;
    }

    private int leftBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || nums[mid] == target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private int rightBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target || nums[mid] == target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,7,7,8,8,10};
        SearchRangeFindFirstAndLast s = new SearchRangeFindFirstAndLast();
        for(int i : s.searchRange(nums, 8)) {
            System.out.println(i);
        }
    }
}
