package ali;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 16:29 2020/4/7
 */
public class LongestIncreasingString_0320 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<String> list = new ArrayList<>();
        while (list.size() < n) {
            list.add(in.nextLine());
        }
        // 将输入字符串按照尾字符大小从小到大排序，如果尾字符大小相同，按照首字符从小到大排序
        list.sort((s1, s2) -> {
            if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
                return s1.charAt(0) - s2.charAt(0);
            }
            return s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1);
        });
        // dp[i]表示i + 'a'的字符结尾的最大长度
        int[] dp = new int[26];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            String str = list.get(i);
            char right = str.charAt(str.length() - 1);
            char left = str.charAt(0);
            int tempMax = 0;
            for (int j = 0; j <= left - 'a'; j++) {
                // 找到能连接该字符的结尾的最大长度
                tempMax = Math.max(tempMax, dp[j]);
            }
            dp[right - 'a'] = tempMax + str.length();
            maxLen = Math.max(maxLen, dp[right - 'a']);
        }
        System.out.println(maxLen);
    }
}
