package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 15:12 2020/4/11
 */

// 给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//示例:
//
//输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
//
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutations-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class PermutationWithSameElements {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, new ArrayList<Integer>(), res, visited);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 判断一个元素如果和前一个元素相同，且前一个元素没有被访问过，则跳过，防止重复
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
