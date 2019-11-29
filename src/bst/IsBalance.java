package bst;

public class IsBalance {
    private boolean res = true;
    public boolean isBalance(TreeNode head) {
        getHeight(head, 1);
        return res;
    }

    private int getHeight(TreeNode head, int level) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1);
        if (!res) {
            return level;
        }
        int rH = getHeight(head.right, level + 1);
        if (!res) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res = false;
        }
        return Math.max(lH, rH);
    }
}
