package ali;

import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 15:49 2020/4/7
 */
// 有一叠扑克牌，每张牌介于1和10之间
//有四种出牌方法：
//
//单出1张
//出2张对子
//出五张顺子，如12345
//出三连对子，如112233
//给10个数，表示1-10每种牌有几张，问最少要多少次能出完
public class Poker_0320 {
    private static int minCount = Integer.MAX_VALUE;
    private static int[] poker = new int[10];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            poker[i] = in.nextInt();
        }
        backtrace(0, 0);
        System.out.println(minCount);
    }

    // 从哪张牌开始，出了几次牌
    private static void backtrace(int from, int count) {
        if (from >= 10) {
            minCount = Math.min(minCount, count);
            return;
        }
        // 没有当前扑克牌，从下一扑克牌开始
        if (poker[from] == 0) {
            backtrace(from + 1, count);
            return;
        }

        // 搜索出牌方案，能出三连对
        if (can3double(from, 3)) {
            takePoker(from, from + 2, 2);
            backtrace(from, count + 1);
            returnBack(from, from + 2, 2);
        }
        // 能出顺子
        if (can5continue(from, 5)) {
            takePoker(from, from + 4, 1);
            backtrace(from, count + 1);
            returnBack(from, from + 4, 1);
        }
        // 能出对子
        if (poker[from] >= 2) {
            takePoker(from, from, 2);
            backtrace(from, count + 1);
            returnBack(from, from, 2);
        }
        // 出单
        takePoker(from, from, 1);
        backtrace(from, count + 1);
        returnBack(from, from, 1);
    }

    private static void takePoker(int from, int end, int count) {
        for (int i = from; i <= end; i++) {
            poker[i] -= count;
        }
    }

    private static void returnBack(int from, int end, int count) {
        for (int i = from; i <= end; i++) {
            poker[i] += count;
        }
    }

    private static boolean can5continue(int from, int count) {
        if (from + count >= 10) {
            return false;
        }
        for (int i = from; i < from + count; i++) {
            if (poker[i] < 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean can3double(int from, int count) {
        if (from + count >= 10) {
            return false;
        }
        for (int i = from; i < from + count; i++) {
            if (poker[i] < 2) {
                return false;
            }
        }
        return true;
    }
}
