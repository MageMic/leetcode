package other;

import java.util.Stack;

/**
 * @Author: zjumic
 * @Date: created at 20:18 2020/3/26
 */
public class LonggestValidKuohao {

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
    // 左右扫描两趟，空间复杂度o1
    public static int longestValidParenthesesLeftRight(String s) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
                if (left == right) {
                    int length = left + right;
                    max = Math.max(max, length);
                } else if (left < right) {
                    left = 0;
                    right = 0;
                }
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
                if (left == right) {
                    int length = left + right;
                    max = Math.max(max, length);
                } else if (left > right) {
                    left = 0;
                    right = 0;
                }
            }
        }
        return max;
    }
}
