package binary_search;

/**
 * @Author: zjumic
 * @Date: created at 19:08 2020/3/9
 */

// 求两个有序数组的中位数
    // 二分法
public class MedianOfTwoSorted_4 {
    public double findMedianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int[] l = nums1;
        int[] s = nums2;
        int m = nums2.length, n = nums1.length;
        if (m > n) {
            l = nums2;
            s = nums1;
            m = nums1.length;
            n = nums2.length;
        }

        int i, j = 0;
        int low = 0, high = m;
        int leftMax = 0, rightMin = 0;

        while (low <= high) {
            i = (low + high) / 2;
            j = (m + n + 1) / 2 - i;
            if (i > 0 && j < n && s[i - 1] > l[j]) {
                high = i - 1;
            } else if (i < m && j > 0 && l[j - 1] > s[i]) {
                low = i + 1;
            } else {
                if (i == 0) {
                    leftMax = l[j - 1];
                } else if (j == 0) {
                    leftMax = s[i - 1];
                } else {
                    leftMax = Math.max(l[j - 1], s[i - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return leftMax;
                }
                if (i == m) {
                    rightMin = l[j];
                } else if (j == n) {
                    rightMin = s[i];
                } else {
                    rightMin = Math.min(l[j], s[i]);
                }
                return (leftMax + rightMin) / 2.0;

            }
        }
        return 0.0;
    }
}
