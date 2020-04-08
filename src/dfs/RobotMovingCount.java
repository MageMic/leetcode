package dfs;

/**
 * @Author: zjumic
 * @Date: created at 20:12 2020/3/6
 */
// 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
// 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格（35,37），
// 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
// 请问该机器人能够达到多少个格子？
public class RobotMovingCount {

    private int rows, cols;
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold == 0 || rows == 0 || cols == 0) {
            return 0;
        }
        this.rows = rows;
        this.cols = cols;

        boolean[] visited = new boolean[rows * cols];

        return dfs(threshold, 0, 0, visited);
    }

    private int dfs(int threshold, int row, int col, boolean[] visited) {
        int count = 0;
        int index = row * cols + col;
        if (check(threshold, row, col, visited)) {
            visited[index] = true;
            count = 1 + dfs(threshold, row + 1, col, visited) +
                    dfs(threshold, row - 1, col, visited) +
                    dfs(threshold, row, col + 1, visited) +
                    dfs(threshold, row, col - 1, visited);
        }
        return count;
    }

    private boolean check(int threshold, int row, int col, boolean[] visited) {
        int index = row * cols + col;
        if (row < rows && row >= 0 && col >= 0 && col < cols && sum(row, col) <= threshold && !visited[index]) {
            return true;
        }
        return false;
    }

    private int sum(int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum;
    }
}
