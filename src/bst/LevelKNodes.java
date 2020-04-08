package bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zjumic
 * @Date: created at 19:37 2020/3/21
 */
public class LevelKNodes {

    public static void main(String[] args) {

        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,2,4,15]");
        System.out.println(countNodes(root, 3));
    }
    public static int countNodes(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            if (level == k) {
                return size;
            }
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return 0;
    }
}
