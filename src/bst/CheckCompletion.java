package bst;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletion {
    public boolean chk(TreeNode root) {
        // write code here
        boolean leaf = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (leaf && (node.left != null || node.right != null) || (node.left == null && node.right != null)) {
                return false;
            }
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                leaf = true;
            }
        }
        return true;
    }

}
