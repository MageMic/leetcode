package practice.zijie;

import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 12:47 2020/4/13
 */
// 链接：https://www.nowcoder.com/questionTerminal/c0803540c94848baac03096745b55b9b?orderByHotValue=1&questionTypes=000100&mutiTagIds=665&page=1&onlyReference=false
//来源：牛客网
//
//1. 两个特工不能埋伏在同一地点
//2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
//
//
//输入描述:
//第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
//
//第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）
//
//
//输出描述:
//一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
//示例1
//输入
//4 3
//1 2 3 4
//输出
//4
//说明
//可选方案 (1, 2, 3), (1, 2, 4), (1, 3, 4), (2, 3, 4)
public class TeGongQujianZuhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        if (n <= 2) {
            System.out.println(-1);
            return;
        }
        int[] locs = new int[n];
        for (int i = 0; i < n; i++) {
            locs[i] = sc.nextInt();
        }
        sc.close();
        long cnt = 0;
        int left = 0, right = 2;
        // 1,2,3 -> C(3,3) = 1
        //1,2,3,4 -> C(4,3) = 4 = 1 + C(3,2)
        //1,2,3,4,5 -> C(5,3) = 10 = 4 + C(4,2)
        while (right < n) {
            if (locs[right] - locs[left] > d) {
                left++;
            } else if (right - left < 2) {
                right++;
            } else {
                cnt += cntInterval(right - left);
                right++;
            }
        }
        cnt = cnt % 99997867;
        System.out.println(cnt);
    }
    // C(n, 2)
    private static long cntInterval(int num) {
        return num * (num - 1) / 2;
    }
}
