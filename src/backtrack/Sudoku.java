package backtrack;

/**
 * @Author: zjumic
 * @Date: created at 17:09 2020/4/11
 */
// 37.解数独，空格用.表示
public class Sudoku {

    private char[][] board;
    private boolean[][] rowUsed = new boolean[9][10];
    private boolean[][] colUsed = new boolean[9][10];
    private boolean[][] cubeUsed = new boolean[9][10];


    public void solveSudoku(char[][] board) {
        this.board = board;
        // 扫描board，把已经用过的数字放进记录里面
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int curNum = board[i][j] - '0';
                    rowUsed[i][curNum] = true;
                    colUsed[j][curNum] = true;
                    cubeUsed[cubeNum(i,j)][curNum] = true;
                }
            }
        }
        backtrack(0, 0);
    }
    // 从第一行开始，从第一列从左到右扫描，第九行扫描结束则返回true
    private boolean backtrack(int r, int c) {
        // 结束的情况：row = 9
        while (r < 9 && board[r][c] != '.') {
            r = c < 8 ? r : r + 1;
            c = c == 8 ? 0 : c + 1;
        }
        if (r == 9) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (rowUsed[r][num] || colUsed[c][num] || cubeUsed[cubeNum(r,c)][num]) {
                continue;
            }
            board[r][c] = (char)(num + '0');
            rowUsed[r][num] = colUsed[c][num] = cubeUsed[cubeNum(r,c)][num] = true;
            if (backtrack(r, c)) {
                return true;
            }
            board[r][c] = '.';
            rowUsed[r][num] = colUsed[c][num] = cubeUsed[cubeNum(r,c)][num] = false;
        }
        return false;
    }

    private int cubeNum(int r, int c) {
        return (r / 3) * 3 + c / 3;
    }
}
