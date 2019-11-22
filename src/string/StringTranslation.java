package string;

public class StringTranslation {
    // 字符串移位
    public String stringTranslation(String A, int n, int len) {
        // write code here
        if (n == len) {
            return A;
        }
        char[] chars = A.toCharArray();
        reverse(chars, 0, len - 1);
        reverse(chars, len, n - 1);
        reverse(chars, 0, n - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0) {
            return;
        }
        while (start < end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
    }
}
