package string;

import java.util.LinkedList;
import java.util.Queue;

// 38.报数
// 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
//
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//1 被读作  "one 1"  ("一个一") , 即 11。
//11 被读作 "two 1s" ("两个一"）, 即 21。
//21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
//
//给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
//
//注意：整数顺序将表示为一个字符串。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/count-and-say
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Submissions_38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return countAndSayLine(countAndSay(n - 1));
    }

    private String countAndSayLine(String s) {
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append("" + count + s.charAt(i - 1));
                count = 1;
            }
        }
        sb.append("" + count + s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Submissions_38().countAndSay(4));
    }
}
