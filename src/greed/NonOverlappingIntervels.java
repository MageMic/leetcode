package greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zjumic
 * @Date: created at 15:12 2020/4/9
 */

// 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
//注意:
//
//可以认为区间的终点总是大于它的起点。
//区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//示例 1:
//
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//示例 2:
//
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/non-overlapping-intervals
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class NonOverlappingIntervels {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervelSchedule(intervals);
    }

    // 区间调度算法，找到最多有多少个不重叠的区间
    public int intervelSchedule(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 按区间end排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 排序后至少有一个区间不相交,以这个区间的end作为判断
        int count = 1;
        int curEnd = intervals[0][1];
        for (int[] intv : intervals) {
            int start = intv[0];
            if (start >= curEnd) {
                count++;
                curEnd = intv[1];
            }
        }
        return count;
    }
}
