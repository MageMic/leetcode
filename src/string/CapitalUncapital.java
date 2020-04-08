package string;

/**
 * @Author: zjumic
 * @Date: created at 22:26 2020/3/12
 */

// 一个字符串，输出前面小写后面大写
public class CapitalUncapital {

    public String reorder(String str) {
        char[] chars = str.toCharArray();
        if (chars.length < 2) {
            return str;
        }
        int i = 0;
        while (i < chars.length) {
            int j = i + 1;
            if (!isCapital(chars[i])) {
                while (!isCapital(chars[j])) {
                    if (j == chars.length - 1) {
                        return new String(chars);
                    }
                    j++;
                }
                int count = j - i;
                char temp = chars[i];
                chars[i] = chars[j];
                while (count > 1) {
                    chars[i + count] = chars[i + count - 1];
                    count--;
                }
                chars[i + 1] = temp;
            }
            i++;
        }
        return new String(chars);
    }

    private boolean isCapital(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CapitalUncapital c = new CapitalUncapital();
        System.out.println(c.reorder("aAbBcC"));
    }
}
