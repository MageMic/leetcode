package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 16:06 2020/4/11
 */
// 78.不重复子集
// 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//
//示例:
//
//输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/subsets
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrack(res, temp, i, nums, 0);
        }
        return  res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int size, int[] nums, int start) {
        if (temp.size() == size) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, temp, size, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
