package backtrack;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

// 93.复原IP地址
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
public class RestoreIpAddresses_93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), ans);
        return ans;
    }

    private void backtrack(String s, int pos, List<String> cur, List<String> ans) {
        if (cur.size() >= 4) {
            if (pos == s.length()) {
                ans.add(String.join(".", cur));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            // 没有这个条件的话会超界
            if (pos + i > s.length()) {
                break;
            }
            String segment = s.substring(pos, pos + i);
            if (segment.startsWith("0") && segment.length() > 1 || (Integer.parseInt(segment) > 255)) {
                continue;
            }
            cur.add(segment);
            backtrack(s, pos + i, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
