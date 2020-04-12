package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 16:58 2020/4/10
 */
// 17
// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//示例:
//
//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class PhoneNumberCombination {

    public static void main(String[] args) {
        String s = "23";
        System.out.println(new PhoneNumberCombination().letterCombinations(s));
    }

    private final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(new StringBuffer(), res, digits);
        return res;
    }

    private void backtrack(StringBuffer prefix, List<String> res, String digits) {
        if (prefix.length() == digits.length()) {
            res.add(prefix.toString());
            return;
        }
        char curNum = digits.charAt(prefix.length());
        String cand = KEYS[curNum - '0'];
        for (int i = 0; i < cand.length(); i++) {
            prefix.append(cand.charAt(i));
            backtrack(prefix, res, digits);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

}
