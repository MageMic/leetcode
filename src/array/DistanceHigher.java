package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zjumic
 * @Date: created at 19:03 2020/3/22
 */

// 比他高的人的距离
public class DistanceHigher {

    public int[] DistanceToHigher (int[] height) {
        // write code here

        int[] result = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            int index = i;
            for (int j = 0; j < i; j++) {
                if (height[i] < height[j]) {
                    index = j;
                }
            }
            result[i] = i - index;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[] {175, 173, 174, 163, 182, 177};
        DistanceHigher d = new DistanceHigher();
        for (int i : d.DistanceToHigher(height)) {
            System.out.println(i);
        }

    }
}
