package bst;

public class MaxSubtree {

    public TreeNode getMax(TreeNode root) {

        if (root == null) {
            return null;
        }
        int[] ret = new int[3];
        return postOrder(root, ret);
    }

    private TreeNode postOrder(TreeNode root, int[] ret) {
        if (root == null) {
            ret[0] = Integer.MIN_VALUE;
            ret[1] = Integer.MAX_VALUE;
            ret[2] = 0;
            return null;
        }
        TreeNode lNode = postOrder(root.left, ret);
        int lmax = ret[0];
        int lmin = ret[1];
        int lnum = ret[2];
        TreeNode rNode = postOrder(root.right, ret);
        int rmax = ret[0];
        int rmin = ret[1];
        int rnum = ret[2];

        ret[0] = Math.max(rmax, root.val);
        ret[1] = Math.min(lmin, root.val);

        if (lNode == root.left && rNode == root.right && lmax < root.val && rmin > root.val) {
            ret[2] = lnum + rnum + 1;
            return root;
        }
        ret[2] = Math.max(lnum, rnum);
        return rnum >= lnum ? rNode : lNode;
    }
}
