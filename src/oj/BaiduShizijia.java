package oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 17:52 2020/3/10
 */
public class BaiduShizijia {

    static char[][] a;
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int T;
        // 读取输入，直到没有整型数据可读
        T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            a = new char[2500][2500];
            int t = cin.nextInt();
            int temp = (int)(Math.pow(3, t - 1) - 1) / 2;
            draw(temp, temp, t);
            System.out.println(String.format("Case #%d", i + 1));
            print((int)Math.pow(3, t - 1));
        }
    }

    private static void draw(int x, int y, int n) {
        if (n == 1) {
            a[x][y] = 'o';
        } else {
            int temp = (int)(Math.pow(3, n - 2));
            draw(x, y, n - 1);
            draw(x - temp, y, n - 1);
            draw(x + temp, y, n - 1);
            draw(x, y + temp, n - 1);
            draw(x, y - temp, n - 1);
        }
    }

    private static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 'o') {
                    System.out.print(' ');
                } else {
                    System.out.print(a[i][j]);
                }
            }
            System.out.println();
        }
    }
}
