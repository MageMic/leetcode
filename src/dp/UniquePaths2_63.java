package dp;

// 63.不同路径2
// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
//网格中的障碍物和空位置分别用 1 和 0 来表示。
//
//说明：m 和 n 的值均不超过 100。
//
//示例 1:
//
//输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/unique-paths-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class UniquePaths2_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 如果入口就是障碍物，肯定不能走了，返回0
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        // 入口为一条路，设置为1
        obstacleGrid[0][0] = 1;
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        // 先遍历第一行和第一列，遇到障碍物则设置为0，否则等于前面的
        for (int i = 1; i < c; i++) {
            if (obstacleGrid[0][i] == 1 ) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }
        }
        for (int i = 1; i < r; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }
        // 扫描数组，如果没有障碍物则为上边+左边，有障碍物设置为0，防止对结果产生影响，这里是把obstacle数组变成储存路径数的dp数组
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[r - 1][c - 1];
    }
}
