package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 17:19 2020/4/10
 */
// 93.复原ip地址
// 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
//示例:
//
//输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/restore-ip-addresses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class RestoreIPAddress {

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddress().restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        doRestore(0, new StringBuffer(), res, s);
        return res;
    }

    private void doRestore(int k, StringBuffer prefix, List<String> res, String s) {
        // 可能已经加到4了，但是s长度还没用完，不应该加入
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                res.add(prefix.toString());
            }
            return;
        }

        for (int i = 0; i < s.length() && i <= 2; i++) {
            // 不能有025.这种形式
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                // 判断前面有没有，如果有的话需要加上.
                if (prefix.length() != 0) {
                    part = "." + part;
                }
                prefix.append(part);
                doRestore(k + 1, prefix, res, s.substring(i + 1));
                prefix.delete(prefix.length() - part.length(), prefix.length());
            }
        }
    }
}
