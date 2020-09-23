package practice.zijie;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 13:31 2020/4/13
 */
public class CoinChange_1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int money = 1024 - value;
        int[] coins = new int[] {1,4,16,64};
        int[] dp = new int[money + 1];
        Arrays.fill(dp, money + 1);
        dp[0] = 0;
        for (int i = 1; i <= money; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        int res = dp[money] > money ? -1 : dp[money];
        System.out.println(res);
    }
}
