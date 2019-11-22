package stack;

import java.util.Stack;

public class StackReverse {

    public int[] reverseStack(int[] A, int n) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        for (int a : A) {
            stack.push(a);
        }
        reverse(stack);
        int[] ret = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }

    private int get(Stack<Integer> s) {
        int result = s.pop();
        if (s.isEmpty()) {
            return result;
        } else {
            int last = get(s);
            s.push(result);
            return last;
        }
    }

    private void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int node = get(s);
        reverse(s);
        s.push(node);
    }
}
