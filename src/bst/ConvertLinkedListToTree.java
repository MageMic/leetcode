package bst;

import linkedlist.ListNode;

/**
 * @Author: zjumic
 * @Date: created at 20:59 2020/3/21
 */
public class ConvertLinkedListToTree {

    public static TreeNode convert(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;

        // 断开中间的
        preMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = convert(head);
        root.right = convert(mid.next);
        return root;
    }

    private static ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
