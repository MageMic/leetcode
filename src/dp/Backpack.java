package dp;

// 01背包问题
public class Backpack {

    public int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        int[] dp = new int[cap + 1];
        for (int i = 0; i < n; i++) {
            for (int j = cap; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[cap];
    }

    public int maxValue2(int[] w, int[] v, int n, int cap) {
        // write code here
       int dp[][] = new int[n + 1][cap + 1];
       for (int i = 1; i < n + 1; i++) {
           for (int j = 1; j < cap + 1; j++) {
               if (j < w[i - 1]) {
                   dp[i][j] = dp[i - 1][j];
               } else {
                   dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
               }
           }
       }
       return dp[n][cap];
    }
}
