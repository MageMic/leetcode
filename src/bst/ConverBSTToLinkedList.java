package bst;

/**
 * @Author: zjumic
 * @Date: created at 20:47 2020/3/21
 */
public class ConverBSTToLinkedList {

    public static TreeNode convert(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode lastLeft = convert(root.left);
        TreeNode p = lastLeft;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (lastLeft != null) {
            p.right = root;
            root.left = p;
        }
        TreeNode right = convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return lastLeft == null ? root : lastLeft;
    }
}
