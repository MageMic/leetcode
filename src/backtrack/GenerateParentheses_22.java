package backtrack;

import util.ArrayListStringUtil;

import java.util.ArrayList;
import java.util.List;

// 22.括号生成
// 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
//例如，给出 n = 3，生成结果为：
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/generate-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class GenerateParentheses_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        backTrack(res, "", 0, 0, n);
        return res;
    }

    private void backTrack(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        } else {
            if (open < max) {
                backTrack(res, cur + "(", open + 1, close, max);
            }
            if (close < open) {
                backTrack(res, cur + ")", open, close + 1, max);
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = new GenerateParentheses_22().generateParenthesis(2);
        System.out.println(ArrayListStringUtil.stringListToString(res));
    }
}
