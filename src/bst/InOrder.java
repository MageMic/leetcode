package bst;

import java.util.Stack;

public class InOrder {

    public void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    public void inOrderCir(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        while (head.left != null || !stack.isEmpty()) {
            if (head.left != null) {
                stack.push(head.left);
                head = head.left;
            } else {
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");
                head = head.right;
            }
        }
    }
}
