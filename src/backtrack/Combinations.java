package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 15:37 2020/4/11
 */
// 77.组合
// 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//示例:
//
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/combinations
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Combinations {

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, 1, n + 1, k);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {
            list.add(i);
            backtrack(res, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}
