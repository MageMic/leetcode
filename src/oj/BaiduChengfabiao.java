package oj;

import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 16:40 2020/3/10
 */
public class BaiduChengfabiao {

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = 0, m = 0, k = 0;
        // 读取输入，直到没有整型数据可读
        while(cin.hasNextInt()) {
            // 读取N 和 M
            n = cin.nextInt();
            m = cin.nextInt();
            k = cin.nextInt();
        }
        int result = chengfabiao(n, m, k);

        System.out.println(result);
    }

    public static int countSum(int n, int m, int k) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (k >= m * i) {
                sum += m;
            } else {
                sum += k / i;
            }
        }
        return sum;
    }

    public static int chengfabiao(int n, int m, int k) {
        int left = 0;
        int right = n * m;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countSum(n, m, mid) < k) {
                left = mid + 1;
            } else if (countSum(n, m, k) > k) {
                right = mid - 1;
            }
        }
        return left;
    }
}
