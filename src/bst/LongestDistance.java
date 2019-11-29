package bst;

public class LongestDistance {

    private int longest = 0;
    public int findLongest(TreeNode root) {
        // write code here
        findDist(root);
        return longest;
    }
    private int findDist(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findDist(root.left);
        int right = findDist(root.right);
        longest = Math.max(left + right + 1, longest);
        return Math.max(left, right) + 1;
    }
}
