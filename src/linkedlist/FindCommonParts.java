package linkedlist;

import java.util.ArrayList;

public class FindCommonParts {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        if (headA == null || headB == null) {
            return null;
        }
        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                list.add(headA.val);
                headA = headA.next;
                headB = headB.next;
            } else {
                if (headA.val < headB.val) {
                    headA = headA.next;
                } else {
                    headB = headB.next;
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
