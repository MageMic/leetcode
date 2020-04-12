package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 18:10 2020/4/11
 */
// 51.N皇后问题
// n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
//上图为 8 皇后问题的一种解法。
//
//给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
//每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//示例:
//
//输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/n-queens
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class NQueens {
    public static void main(String[] args) {
        NQueens n = new NQueens();
        System.out.println(n.solveNQueens(5));
    }

    private char[][] nQueens;
    List<List<String>> res = new ArrayList<>();
    private boolean[] colUsed;
    private boolean[] d45Used;
    private boolean[] d135Used;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return res;
        }
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        colUsed = new boolean[n];
        d45Used = new boolean[2 * n - 1];
        d135Used = new boolean[2 * n - 1];
        backtrack(0, n);
        return res;
    }
    // 每一行尝试在每一列上放置
    private void backtrack(int row, int n) {
        if (row == n) {
            List<String> curAns = new ArrayList<>();
            for (char[] r : nQueens) {
                curAns.add(new String(r));
            }
            res.add(curAns);
        }

        for (int col = 0; col < n; col++) {
            int d45 = row + col;
            int d135 = n - 1 + col - row; // 135对角线的坐标
            if (colUsed[col] || d45Used[d45] || d135Used[d135]) {
                continue;
            }
            nQueens[row][col] = 'Q';
            colUsed[col] = d45Used[d45] = d135Used[d135] = true;
            backtrack(row + 1, n);
            nQueens[row][col] = '.';
            colUsed[col] = d45Used[d45] = d135Used[d135] = false;
        }
    }
}
