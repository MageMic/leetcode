package backtrack;

import util.ArrayListStringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//示例:
//
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutations
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class Permutations_46 {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, 0);
        return result;
    }

    private void backTrack(int[] nums, int first) {
        if (first == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            result.add(list);
        }
        for (int i = first; i < nums.length; i++) {
            swap(nums, first, i);
            backTrack(nums, first + 1);
            swap(nums, first, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> result = new Permutations_46().permute(new int[] {1,2,3});
        System.out.println(ArrayListStringUtil.int2dListToString(result));
    }
}
