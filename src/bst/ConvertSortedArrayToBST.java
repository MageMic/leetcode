package bst;

/**
 * @Author: zjumic
 * @Date: created at 21:07 2020/3/21
 */
public class ConvertSortedArrayToBST {

    public static TreeNode convert(int[] nums) {
        return arrToBST(nums, 0, nums.length - 1);
    }
    private static TreeNode arrToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrToBST(nums, start, mid - 1);
        root.right = arrToBST(nums, mid + 1, end);
        return root;
    }
}
