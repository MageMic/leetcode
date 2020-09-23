package tengxun;

import java.util.*;

/**
 * @Author: zjumic
 * @Date: created at 21:28 2020/9/6
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] median = findMedian(arr);
        for (int num : arr) {
            if (num <= median[0]) {
                System.out.println(median[1]);
            } else if (num >= median[1]) {
                System.out.println(median[0]);
            }
        }
    }

    private static int[] findMedian(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        int smaller = arr.length / 2 - 1;
        int bigger = arr.length / 2;
        return new int[] {sorted[smaller], sorted[bigger]};
    }
}
