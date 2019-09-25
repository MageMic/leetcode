package linkedlist;

// 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//示例：
//
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class RemoveNthNodeFromEndOfList19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p1 = dummyHead;
        ListNode p2 = dummyHead;

        for (int i = 0; i <= n; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        ListNode delNode = p2.next;
        p2.next = delNode.next;
        delNode.next = null;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,4,5]";
        ListNode head = ListNode.stringToListNode(str);
        String result = ListNode.listNodeToString(new RemoveNthNodeFromEndOfList19().removeNthFromEnd(head, 2));
        System.out.println(result);
    }
}
