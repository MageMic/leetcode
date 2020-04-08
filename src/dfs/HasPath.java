package dfs;

import java.util.Arrays;

/**
 * @Author: zjumic
 * @Date: created at 19:53 2020/3/6
 */
public class HasPath {

    private int rows, cols;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        if (matrix == null || rows == 0 || cols == 0 || str == null) {
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        Arrays.fill(visited, false);

        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasThisChar(matrix, i, j, pathLength, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasThisChar(char[] matrix, int row, int col, int pathLength, char[] str, boolean[] visited) {
        if (pathLength == str.length) {
            return true;
        }
        boolean result = false;
        int index = row * cols + col;
        if (row < rows && row >= 0 && col >= 0 && col < cols && !visited[index] && str[pathLength] == matrix[index]) {
            pathLength++;
            visited[index] = true;
            result = hasThisChar(matrix, row + 1, col, pathLength, str, visited) ||
                    hasThisChar(matrix, row - 1, col, pathLength, str, visited) ||
                    hasThisChar(matrix, row, col + 1, pathLength, str, visited) ||
                    hasThisChar(matrix, row, col - 1, pathLength, str, visited);
            if (!result) {
                pathLength--;
                visited[index] = false;
            }
        }

        return result;
    }
}
