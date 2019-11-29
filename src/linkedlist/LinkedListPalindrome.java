package linkedlist;

import java.util.Stack;

public class LinkedListPalindrome {
    // 方法1
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        ListNode cur = pHead;
        Stack<Integer> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = pHead;
        while (!stack.isEmpty()) {
            if (cur.val != stack.pop()) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}
