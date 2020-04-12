package array;

import java.util.Arrays;

/**
 * @Author: zjumic
 * @Date: created at 16:51 2020/4/12
 */
// 237.除自身以外的数组乘积
// 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
// 
//
//示例:
//
//输入: [1,2,3,4]
//输出: [24,12,8,6]
// 
//
//提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
//
//说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/product-of-array-except-self
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        Arrays.fill(product, 1);
        // 从左往右乘
        int left = 1;
        for (int i = 1; i < nums.length; i++) {
            left *= nums[i - 1];
            product[i] *= left;
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            product[i] *= right;
        }
        return product;
    }
}
