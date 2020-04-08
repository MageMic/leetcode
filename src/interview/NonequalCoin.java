package interview;

import java.util.Random;

/**
 * @Author: zjumic
 * @Date: created at 22:21 2020/3/8
 */

// 一硬币，一面向上概率0.7，一面0.3，如何公平
public class NonequalCoin {

    static double p = 0.7;

    private int f() {
        return new Random().nextDouble() < p ? 1 : 0;
    }

    public int random01() {
        int[] random = new int[2];
        random[0] = f();
        random[1] = f();

        while (random[0] == random[1]) {
            random[0] = f();
            random[1] = f();
        }
        return random[0] == 0 ? 0 : 1;
    }

    public static void main(String[] args) {
        int count0 = 0;
        int count1 = 0;
        NonequalCoin coin = new NonequalCoin();
        for (int i = 0; i < 1000; i++) {
            if (coin.random01() == 0) {
                count0++;
            } else {
                count1++;
            }
        }
        System.out.println(count0);
        System.out.println(count1);
    }
}
