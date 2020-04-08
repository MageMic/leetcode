package dp;

/**
 * @Author: zjumic
 * @Date: created at 13:21 2020/3/31
 */
public class Stock {

    // 股票利润1，只可以交易1次，k=1
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0; // 没有持有股票，有两种情况，前一天没有持有，今天继续rest；前一天持有，今天卖掉
        int dp_i_1 = Integer.MIN_VALUE; // 持有股票，有两种情况，前一天持有，今天rest；前一天没有持有，今天买的

        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    // 股票利润2，不限交易次数，k=infinity
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0; // 没有持有股票，有两种情况，前一天没有持有，今天继续rest；前一天持有，今天卖掉
        int dp_i_1 = Integer.MIN_VALUE; // 持有股票，有两种情况，前一天持有，今天rest；前一天没有持有，今天买的

        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    // 股票利润3，不限交易次数，但是每次sell之后需要隔一天才能交易，k=infinity with cooldown
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0; // 没有持有股票，有两种情况，前一天没有持有，今天继续rest；前一天持有，今天卖掉
        int dp_i_1 = Integer.MIN_VALUE; // 持有股票，有两种情况，前一天持有，今天rest；前一天没有持有，今天买的
        int dp_pre_0 = 0; // 代表dp[i - 2][0]
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

    // 股票利润4，k=2
    public int maxProfit4(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    // 股票利润5，k=any integer
    public int maxProfit5(int[] prices, int max_k) {
        int n = prices.length;
        // 如果k比n的一半要大，因此一次交易需要两天，所以此情况等于k为无限
        if (max_k > n / 2) {
            return maxProfit2(prices);
        }
        int dp[][][] = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                } else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][max_k][0];
    }
}
