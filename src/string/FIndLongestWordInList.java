package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 22:42 2020/4/8
 */

// 524 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
//
//示例 1:
//
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出:
//"apple"
//示例 2:
//
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出:
//"a"
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class FIndLongestWordInList {

    public static void main(String[] args) {
        String s = "abpcplea";
        ArrayList<String> d = new ArrayList<>(
                Arrays.asList("ale", "apple", "monkey", "plea")
        );
        FIndLongestWordInList f = new FIndLongestWordInList();
        System.out.println(f.findLongestWord(s,d));
    }

    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String target : d) {
            int l1 = longest.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longest.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstring(s, target)) {
                longest = target;
            }
        }
        return longest;
    }

    private boolean isSubstring(String s, String cand) {
        int i = 0, j = 0;
        while (i < s.length() && j < cand.length()) {
            if (s.charAt(i) == cand.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == cand.length();
    }
}
