package string;

/**
 * @Author: zjumic
 * @Date: created at 16:54 2020/4/9
 */
// 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
//你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
//
//字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//示例 1:
//s = "abc", t = "ahbgdc"
//
//返回 true.
//
//示例 2:
//s = "axc", t = "ahbgdc"
//
//返回 false.
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/is-subsequence
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class IsSubstring {

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 找到当前找到的字符的下一个字符的下标，下一个字符从下标+1开始
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
