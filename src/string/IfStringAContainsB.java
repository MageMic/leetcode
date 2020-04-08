package string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @Author: zjumic
 * @Date: created at 12:06 2020/3/23
 */
// A字符串中是否有包含B字符串中所有字符的子串，如果有返回最小值
public class IfStringAContainsB {
    public static void main(String[] args) {
        String A = "absddackkk";
        String B = "bac";
        System.out.println(ifContains(A, B));
    }
    public static int ifContains(String A, String B) {
        if (A.length() < B.length()) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < B.length(); i++) {
            set.add(B.charAt(i));
        }
        char[] arrA = A.toCharArray();
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arrA.length; i++) {
            char cur = arrA[i];
            if (set.contains(cur)) {
                indexMap.put(cur, i);
            }
        }
        if (set.size() == indexMap.size()) {
            return indexMap.values().stream().max(Comparator.naturalOrder()).get()
                    - indexMap.values().stream().min(Comparator.naturalOrder()).get() + 1;
        }
        return 0;
    }
}
