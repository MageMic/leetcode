package dfs;

/**
 * @Author: zjumic
 * @Date: created at 14:10 2020/4/10
 */

// 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
//找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
//示例:
//
//X X X X
//X O O X
//X X O X
//X O X X
//运行你的函数后，矩阵变为：
//
//X X X X
//X X X X
//X X X X
//X O X X
//解释:
//
//被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/surrounded-regions
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class SurrondedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        boolean isEdge;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                // 从边界开始搜索连接的O，不替换
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || board[i][j] == 'X' || board[i][j] == '#') {
            // '#'表示搜索过了
            return;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
