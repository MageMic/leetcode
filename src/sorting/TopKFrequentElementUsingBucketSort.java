package sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zjumic
 * @Date: created at 23:09 2020/4/8
 */

// 前k个高频元素
// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//示例 1:
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//
//输入: nums = [1], k = 1
//输出: [1]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/top-k-frequent-elements
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class TopKFrequentElementUsingBucketSort {

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,2,3};
        List<Integer> list = topKFrequent(nums, 1);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Map.Entry entry : map.entrySet()) {
            int count = (Integer)entry.getValue();
            int num = (Integer)entry.getKey();
            List<Integer> cur;
            if (buckets[count] == null) {
                cur = new ArrayList<>();
            } else {
                cur = buckets[count];
            }
            cur.add(num);
            buckets[count] = cur;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            result.addAll(buckets[i]);
        }
        return result;
    }
}
