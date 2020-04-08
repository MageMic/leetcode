package array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zjumic
 * @Date: created at 19:51 2020/3/28
 */
// 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
//
//如果没有和至少为 K 的非空子数组，返回 -1 。
//
// 
//
//示例 1：
//
//输入：A = [1], K = 1
//输出：1
//示例 2：
//
//输入：A = [1,2], K = 4
//输出：-1
//示例 3：
//
//输入：A = [2,-1,2], K = 3
//输出：3
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class ShortestSubArrWithSumAtLeastKUsingSlideWindow {
    // 滑动窗口记录前缀和下标（p[x] <= p[y] - K）
    public int shortestSubarray(int[] A, int K) {
        long[] p = new long[A.length + 1];
        // 求前缀和
        for (int i = 0; i < A.length; i++) {
            p[i + 1] = p[i] + (long)A[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        int res = A.length + 1;
        for (int y = 0; y < p.length; y++) {
            // 当p[y] <= p[y1], 保证队列单调递增,候选是用当前y - y1或y2，如果y1<y2,那么候选值就变大了，不符合至少
            // 所以如果y1<y2且p[y2]<=p[y1]，那么移除y1
            while (!deque.isEmpty() && p[y] <= p[deque.getLast()]) {
                deque.removeLast();
            }
            // 当符合条件p[y]-p[x]>=K时，从候选的y值里面选取最小的下标差并计算
            while (!deque.isEmpty() && p[y] >= p[deque.getFirst()] + K) {
                res = Math.min(res, y - deque.removeFirst());
            }
            deque.addLast(y);
        }
        return res < A.length + 1 ? res : -1;
    }
}

