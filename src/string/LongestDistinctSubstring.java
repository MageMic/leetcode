package string;

import java.util.HashMap;

public class LongestDistinctSubstring {

    public int longestSubstring(String A, int n) {
        // write code here

        char[] strArr = A.toCharArray();
        HashMap<Character, Integer> index = new HashMap<>();
        int pre = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!index.containsKey(strArr[i])) {
                index.put(strArr[i], i);
                pre++;
            } else {
                int posA = index.get(strArr[i]) + 1;
                int posB = i - pre;

                if (posA > posB) {
                    pre = i - posA + 1;
                } else {
                    pre++;
                }
                index.put(strArr[i], i);
            }
            if (pre > max) {
                max = pre;
            }
        }
        return max;
    }
}
