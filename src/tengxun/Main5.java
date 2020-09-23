package tengxun;


/**
 * @Author: zjumic
 * @Date: created at 21:42 2020/9/6
 */
public class Main5 {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode three = new ListNode(3);

        head.next = second;
        second.next = three;

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
        }

        System.out.println();

        cur = reverse(cur);
        while (cur != null) {
            System.out.print(cur.val + " ");
        }

    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
