package backtrack;

// 39.组合总和
// 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。
//
//说明：
//
//所有数字（包括 target）都是正整数。
//解集不能包含重复的组合。 
//示例 1:
//
//输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/combination-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum_39 {

    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 一定要排序
        Arrays.sort(candidates);
        Stack<Integer> stack = new Stack<>();
        helper(candidates, 0, target, stack);
        return ret;
    }

    private void helper(int[] candidates, int start, int residual, Stack<Integer> stack) {
        if (residual == 0) {
            ret.add(new ArrayList(stack));
            return;
        }
        // 大于等于很关键
        for (int i = start; i < candidates.length && residual - candidates[i] >= 0; i++) {
            stack.push(candidates[i]);
            helper(candidates, i, residual - candidates[i], stack);
            stack.pop();
        }
    }
}
