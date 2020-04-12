package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 17:38 2020/4/9
 */
// 划分字母区间
// 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
//
//示例 1:
//
//输入: S = "ababcbacadefegdehijhklij"
//输出: [9,7,8]
//解释:
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/partition-labels
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class PartitionLabelsHuaFenQuJian {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        for (int i : partitionLabels(s)) {
            System.out.print(i + ",");
        }
    }

    public static List<Integer> partitionLabels(String S) {
        int[] lastIndexOfChar = new int[26];
        // 记录所有字符出现的最后一位下标
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            lastIndexOfChar[cur - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < S.length()) {
            int lastIndex = firstIndex;
            // 扫描每一位字符最后出现的下标，如果有比最后出现的还要大的，将最后字符更新
            for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
                char cur = S.charAt(i);
                int index = lastIndexOfChar[cur - 'a'];
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            res.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return res;
    }
}
