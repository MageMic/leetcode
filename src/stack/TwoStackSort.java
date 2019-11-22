package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class TwoStackSort {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();

        ArrayList<Integer> ret = new ArrayList<>();
        for (int num : numbers) {
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (help.isEmpty() || cur <= help.peek()) {
                help.push(cur);
            } else {
                while (!help.isEmpty() && cur > help.peek()) {
                    stack.push(help.pop());
                }
                help.push(cur);
            }
        }
        while (!help.isEmpty()) {
            ret.add(help.pop());
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        TwoStackSort s1 = new TwoStackSort();
        System.out.println(s1.twoStacksSort(new int[] {2,1,5,4,0}));
    }
}
