package dp;

public class MinCost {
    public int findMinCost(String A, int m, String B, int n, int ic, int dc, int rc) {
        // write code here
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = dc * i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = ic * j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int deleteCost = dc + dp[i - 1][j];
                int insertCost = ic + dp[i][j - 1];
                int min = Math.min(deleteCost, insertCost);
                if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    dp[i][j] = Math.min(min, dp[i - 1][j - 1] + rc);
                } else {
                    dp[i][j] = Math.min(min, dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
