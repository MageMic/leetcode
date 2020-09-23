package practice.zijie;

import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 13:45 2020/4/13
 */
// 链接：https://www.nowcoder.com/questionTerminal/448127caa21e462f9c9755589a8f2416?orderByHotValue=1&questionTypes=000100&mutiTagIds=665&page=1&onlyReference=false
//来源：牛客网
//
//总共有36张牌，每张牌是1~9。每个数字4张牌。
//你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
//14张牌中有2张相同数字的牌，称为雀头。
//除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）
//
//例如：
//1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
//1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
//1 1 1 2 2 2 3 3 3 5 6 7 7 9 无论用1 2 3 7哪个做雀头，都无法组成和牌的条件。
//
//现在，小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。
public class HupaiQuehun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pai = new int[13];
        int[] count = new int[9];
        for (int i = 0; i < 13; i++) {
            pai[i] = sc.nextInt();
            count[pai[i] - 1]++;
        }
        int winCount = 0;
        for (int i = 1; i <= 9; i++) { // 从1-9开始尝试
            if (count[i - 1] < 4) {
                count[i - 1]++;
                if (win(count)) {
                    winCount++;
                    System.out.print(i + " ");
                }
                count[i - 1]--;
            }
        }
        if (winCount == 0) {
            System.out.println(0);
        }
    }

    private static boolean win(int[] count) {
        // 从1到9里选一个做雀头（2张）,然后判断剩下的能否组成4个刻子或者4个顺子
        for (int i = 0; i < 9; i++) {
            if (count[i] < 2) {
                continue;
            }
            count[i] -= 2;
            if (hasTriples(count, 4)) {
                count[i] += 2;
                return true;
            }
            count[i] += 2;
        }
        return false;
    }

    private static boolean hasTriples(int[] count, int n) {
        if (n == 0) {
            return true;
        }
        // 1-9 每一张尝试顺子或者刻子
        for (int i = 0; i < 9; i++) { // 刻子
            if (count[i] >= 3) {
                count[i] -= 3;
                boolean subRes = hasTriples(count, n - 1);
                count[i] += 3;
                if (subRes) {
                    return true;
                }
            }
            if (i < 7 && count[i] >= 1 && count[i + 1] >= 1 && count[i + 2] >= 1) {
                count[i]--;
                count[i + 1]--;
                count[i + 2]--;
                boolean subRes = hasTriples(count, n - 1);
                count[i]++;
                count[i + 1]++;
                count[i + 2]++;
                if (subRes) {
                    return true;
                }
            }
        }
        return false;
    }
}
