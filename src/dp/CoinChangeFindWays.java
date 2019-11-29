package dp;


// 问一共有多少种方法，注意和322的区别： 内外套循环不一样
public class CoinChangeFindWays {

    public int countWays(int[] penny, int n, int aim) {
        // write code here
        int[] dp = new int[aim + 1];
        for (int i = 0; i < aim + 1; i++) {
            if (i % penny[0] == 0){
                dp[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < aim + 1; j++) {
                if (j >= penny[i]) {
                    dp[j] += dp[j - penny[i]];
                }
            }
        }
        return dp[aim];

    }
}
