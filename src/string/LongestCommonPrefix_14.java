package string;

import java.util.ArrayList;

// 14.最长公共前缀
// 编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//
//输入: ["flower","flow","flight"]
//输出: "fl"
//示例 2:
//
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-common-prefix
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            String cur = strs[i];
            while (index < common.length() && index < cur.length()) {
                if (common.charAt(index) == cur.charAt(index)) {
                    index++;
                } else {
                    break;
                }
            }
            if (index == 0) {
                common = "";
                break;
            } else {
                common = common.substring(0, index);
            }
        }
        return common;
    }

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("flower");
        list.add("flow");
        list.add("flight");
        String[] strs = new String[0];
        strs = list.toArray(strs);
        System.out.println(new LongestCommonPrefix_14().longestCommonPrefix(strs));
    }
}
