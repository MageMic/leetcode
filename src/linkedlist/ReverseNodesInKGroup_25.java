package linkedlist;

import java.util.Stack;

// 25.K个一组翻转链表
// 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
//k 是一个正整数，它的值小于或等于链表的长度。
//
//如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//示例 :
//
//给定这个链表：1->2->3->4->5
//
//当 k = 2 时，应当返回: 2->1->4->3->5
//
//当 k = 3 时，应当返回: 3->2->1->4->5
//
//说明 :
//
//你的算法只能使用常数的额外空间。
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class ReverseNodesInKGroup_25 {

    // 思路1，用栈
    public ListNode reverseByStack(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        Stack<ListNode> stack = new Stack<>();

        while (true) {
            int count = 0;
            ListNode temp = head;
            while (temp != null && count < k) {
                stack.add(temp);
                temp = temp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            p.next = temp;
            head = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,4,5]";
        ListNode head = ListNode.stringToListNode(str);
        String result = ListNode.listNodeToString(new ReverseNodesInKGroup_25().reverseByStack(head, 2));
        System.out.println(result);
    }
}
