package linkedlist;

/**
 * @Author: zjumic
 * @Date: created at 14:38 2020/3/6
 */
public class LoopNode {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        ListNode mNode = findMeetingNode(pHead);

        if (mNode == null) {
            return null;
        }
        ListNode nodeInLoop = mNode;
        int loop = 1;
        while (nodeInLoop.next != mNode) {
            loop++;
            nodeInLoop = nodeInLoop.next;
        }
        for (int i = 0; i < loop; i++) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode findMeetingNode(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        if (fast.next == null) {
            return null;
        }
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }
}
