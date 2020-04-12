package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 14:52 2020/4/10
 */
// 417.大西洋太平洋水流
// 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
//
//规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
//
//请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
//
// 
//
//提示：
//
//输出坐标的顺序不重要
//m 和 n 都小于150
// 
//
//示例：
//
// 
//
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class PacificAtlantic {

    private int[][] direction = new int[][] {{1,0}, {0,1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, canReachP);
            dfs(matrix, i, n - 1, canReachA);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, canReachP);
            dfs(matrix, m - 1, j, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (nextR < 0 || nextC < 0 || nextR > matrix.length - 1 || nextC > matrix[0].length - 1
                    || matrix[nextR][nextC] < matrix[r][c]) { // 这里是小于，因为是从高处流向边缘，所以要搜索比当前值大的
                continue;
            }
            dfs(matrix, nextR, nextC, canReach);
        }
    }
}
