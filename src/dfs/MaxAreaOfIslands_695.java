package dfs;

public class MaxAreaOfIslands_695 {

    public int dfs(int[][] grid, int r, int c) {
        int nr = grid.length - 1;
        int nc = grid[0].length - 1;

        if (r < 0 || c < 0 || r > nr || c > nc || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return dfs(grid, r, c + 1) + dfs(grid, r, c - 1) + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,0,1,1}, {0,0,0,1,1}};
        System.out.println(new MaxAreaOfIslands_695().maxAreaOfIsland(grid));
    }
}
