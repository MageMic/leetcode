package bfs;

import java.util.*;

/**
 * @Author: zjumic
 * @Date: created at 23:45 2020/4/9
 */
// 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
//示例 1:
//
//输入: n = 12
//输出: 3
//解释: 12 = 4 + 4 + 4.
//示例 2:
//
//输入: n = 13
//输出: 2
//解释: 13 = 4 + 9.
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/perfect-squares
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class NumSquaresWanQuanPingFang {
    public static void main(String[] args) {
        NumSquaresWanQuanPingFang n = new NumSquaresWanQuanPingFang();
        System.out.println(n.numSquares(13));
    }
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level = 0;
        List<Integer> squares = generateSquares(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    } else if (next == 0) {
                        return level;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return n;
    }

    private List<Integer> generateSquares(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            res.add(square);
            square += diff;
            diff += 2;
        }
        return res;
    }
}
