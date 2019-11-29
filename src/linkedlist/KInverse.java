package linkedlist;

public class KInverse {

    public ListNode inverse(ListNode head, int k) {
        // write code here
        ListNode pre = head;
        int count = 0;
        while (pre != null && count != k) {
            pre = pre.next;
            count++;
        }
        // 此时的pre就是第k+1个节点
        if (count == k) {
            // 新的pre是翻转老的之后返回的第一个节点，也就是下一段的起点
            pre = inverse(pre, k);
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            // pre为反转后的第一个节点
            head = pre;
        }
        return head;
    }
}
