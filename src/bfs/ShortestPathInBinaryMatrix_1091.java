package bfs;

import java.util.LinkedList;
import java.util.Queue;

// 1091.二进制矩阵中的最短路径
// 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
//
//一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
//
//相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
//C_1 位于 (0, 0)（即，值为 grid[0][0]）
//C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
//如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
//返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class ShortestPathInBinaryMatrix_1091 {

    private class Pair {
        private int key;
        private int val;
        Pair(int k, int v) {
            this.key = k;
            this.val = v;
        }
        int getKey() {
            return key;
        }
        int getVal() {
            return val;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] direction = {{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
        Queue<Pair> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        // boolean[][] flag = new boolean[m][n];
        // flag[0][0] = true;
        int pathLength = 0;
        queue.add(new Pair(0,0));
        while (!queue.isEmpty()) {
            pathLength++;
            int size = queue.size();
            while (size-- > 0) {
                Pair cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getVal();
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 1) {
                        continue;
                    }
                    grid[nr][nc] = 1;
                    queue.add(new Pair(nr, nc));
                }
            }
        }
        return -1;
    }
}
