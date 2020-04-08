package dp;

/**
 * @Author: zjumic
 * @Date: created at 20:36 2020/3/6
 */
public class CutRope {

    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int res = 0;
        for (int i = 4; i < dp.length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                res = Math.max(res, dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }
        return dp[target];
    }
}
