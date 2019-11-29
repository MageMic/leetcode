package bst;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public void printLevel(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int nextLevel = 0;
        int thisLevel = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            thisLevel--;
            if (thisLevel == 0) {
                System.out.println();
                thisLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
