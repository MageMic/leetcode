package bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zjumic
 * @Date: created at 12:38 2020/3/18
 */
public class FindDistanceOfTwoNodes {
    public int findDistanceOfTwoNodes(TreeNode root, TreeNode o1, TreeNode o2) {
        TreeNode lac = lowestAncestor(root, o1, o2);
        return distanceFromRoot(root, o1) + distanceFromRoot(root, o2) - 2 * distanceFromRoot(root, lac);
    }

    private TreeNode lowestAncestor(TreeNode root, TreeNode o1, TreeNode o2) {
        if (root == null || o1 == root || o2 == root) {
            return root;
        }
        TreeNode left = lowestAncestor(root.left, o1, o2);
        TreeNode right = lowestAncestor(root.right, o1, o2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private int distanceFromRoot(TreeNode root, TreeNode node) {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                TreeNode n = queue.poll();
                if (n == node) {
                    return level;
                }
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
        }
        return -1;
    }
}
