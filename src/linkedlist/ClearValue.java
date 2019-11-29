package linkedlist;

public class ClearValue {
    public ListNode clear(ListNode head, int val) {
        // write code here
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                cur.next = head;
                head = head.next;
                cur = cur.next;
            }
        }
        cur.next = null;
        return dummy.next;
    }
}
