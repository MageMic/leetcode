package dp;

public class LongestCommonSubstring {

    public int findLCS(String A, int m, String B, int n) {
        // write code here
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                dp[i][0] = 1;
                for (int j = i + 1; j < m; j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (B.charAt(i) == A.charAt(0)) {
                dp[0][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    dp[0][j] = 1;
                }
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int max = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if (A.charAt(i) == B.charAt(j)) {
                    max = Math.max(dp[i - 1][j - 1] + 1, max);
                }
                dp[i][j] = max;
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        String s1 = "joneoovzzmuispkgmnhqgdmbchdntanbofhcwftcdnbsyvcragunnopknzazjqoprujqfiesoreslzvgzaed";
        String s2 = "oynwkodiovsvkliehbvvggpdydesncaentayeufhoaaildsdwkfpnvxwpsqcujtssriiudgyxstiefyvsp";
        System.out.println(longestCommonSubstring.findLCS(s1, s1.length(), s2, s2.length()));
    }
}
