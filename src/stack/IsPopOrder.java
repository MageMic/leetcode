package stack;

import java.util.Stack;

/**
 * @Author: zjumic
 * @Date: created at 20:21 2020/3/28
 */
public class IsPopOrder {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        int popIndex = 0;

        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
