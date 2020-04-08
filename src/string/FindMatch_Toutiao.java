package string;

import java.util.HashMap;

/**
 * @Author: zjumic
 * @Date: created at 23:20 2020/3/8
 */

//给定m个不重复的字符 [a, b, c, d]，以及一个长度为n的字符串tbcacbdata，
// 问能否在这个字符串中找到一个长度为m的连续子串，使得这个子串刚好由上面m个字符组成，
// 顺序无所谓，返回任意满足条件的一个子串的起始位置，未找到返回-1。比如上面这个例子，acbd，3。
public class FindMatch_Toutiao {

    public int findMatch(char[] chars, String str) {
        int len = str.length();
        int w = chars.length;
        if (w == 0 || chars.length > len || str.length() == 0) {
            return -1;
        }
        int result = -1;
        char[] s = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, -w - 1);
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s[i])) {
                if (map.get(s[i]) < i - w) {
                    count++;
                    map.put(s[i], i);
                }
            } else {
                count = 0;
            }
            if (count == w) {
                result = i - count + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindMatch_Toutiao f = new FindMatch_Toutiao();
        char[] chars = new char[] {'a','b','c','d'};
        System.out.println(f.findMatch(chars, "esssbcad"));
    }
}
