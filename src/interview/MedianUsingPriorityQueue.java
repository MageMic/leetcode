package interview;

import java.util.PriorityQueue;

/**
 * @Author: zjumic
 * @Date: created at 17:40 2020/3/6
 */
public class MedianUsingPriorityQueue {

    int count = 0;
    PriorityQueue<Integer> leftMax = new PriorityQueue<>((i1, i2) -> i2 - i1);
    PriorityQueue<Integer> rightMin = new PriorityQueue<>();

    public void insert(int num) {
        count++;
        if ((count & 1) == 1) {
            if (!rightMin.isEmpty() && num > rightMin.peek()) {
                rightMin.add(num);
                num = rightMin.poll();
            }
            leftMax.add(num);
        } else {
            if (!leftMax.isEmpty() && num < leftMax.peek()) {
                leftMax.add(num);
                num = leftMax.poll();
            }
            rightMin.add(num);
        }
    }

    public double getMedian() {
        int size = leftMax.size() + rightMin.size();
        int left = leftMax.peek();
        int right = rightMin.peek();

        if ((size & 1) == 1) {
            return left;
        } else {
            return (left + right) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianUsingPriorityQueue m = new MedianUsingPriorityQueue();
        int[] nums = new int[] {1,3,4,2,5,0,1,2,8,3};
        for (int num : nums) {
            m.insert(num);
        }
        m.leftMax.forEach(System.out::print);
        System.out.println();
        m.rightMin.forEach(System.out::print);
        System.out.println();
        System.out.println(m.getMedian());
    }
}
