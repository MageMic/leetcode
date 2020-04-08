package dp;

/**
 * @Author: zjumic
 * @Date: created at 19:35 2020/3/20
 */
// 完全背包问题
public class FullBackPack {

    public static void main(String[] args) {
        int[] w = new int[] {1, 2, 3, 4};
        int[] v = new int[] {2, 4, 4, 5};
        System.out.println(maxValue(w,v,4,5));
    }

    // 状态方程：dp[i][j]表示：对第i件物品，容量为j时的最大价值
    public static int maxValue(int[] w, int[] v, int n, int cap) {
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < cap + 1; j++) {
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 与完全背包不同，完全背包是
                    // dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }
}
