import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 19:29 2020/4/10
 */
public class PDD2 {

    private static long[] sumAtIndex;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sumAtIndex = new long[n];
        sumAtIndex[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sumAtIndex[i] = sumAtIndex[i - 1] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += validIntervals(nums, k, i);
        }
        System.out.println(res);
    }

    private static int validIntervals(int[] nums, int k, int start) {
        int cnt = 0;
        for (int i = 0; start + i < nums.length; i++) {
            if (getSum(start, start + i) % k == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    private static long getSum(int start, int end) {
        if (start == 0) {
            return sumAtIndex[end];
        }
        return sumAtIndex[end] - sumAtIndex[start - 1];
    }
}
