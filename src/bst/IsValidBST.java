package bst;

/**
 * @Author: zjumic
 * @Date: created at 15:29 2020/3/27
 */
public class IsValidBST {
    private static long last = Long.MIN_VALUE;
    public static boolean isValid(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValid(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValid(root.right);
            }
        }
        return false;
    }
}
