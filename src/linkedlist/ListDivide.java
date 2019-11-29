package linkedlist;

public class ListDivide {

    public ListNode listDivide(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        ListNode dummyLarge = new ListNode(-1);
        ListNode large = dummyLarge;
        while (head != null) {
            if (head.val > val) {
                // 移动大于值的链表
                large.next = head;
                large = large.next;
                // 处理小于值的链表
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        large.next = null;
        pre.next = dummyLarge.next;
        return dummy.next;
    }
}
