package array;

/**
 * @Author: zjumic
 * @Date: created at 0:04 2020/4/9
 */

// 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//注意:
//不能使用代码库中的排序函数来解决这道题。
//
//示例:
//
//输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sort-colors
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class SortColor012 {

    public static void main(String[] args) {
        SortColor012 s = new SortColor012();
        int[] nums = new int[] {2,0,2,1,1,0};
        s.sortColors(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }

    public void sortColors(int[] nums) {
        int i0 = 0, i = 0, i2 = nums.length - 1;
        while (i <= i2) {
            if (nums[i] == 0) {
                swap(nums, i0++, i++);
            } else if (nums[i] == 2) {
                swap(nums, i2--, i);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
