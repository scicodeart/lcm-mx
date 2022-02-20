package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai@tuya.com
 * @date 2022/2/16 12:47 PM
 */
public class UniquePathsWithObstacles {

    class Solution {

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            //递推公式 dp[i][j] = dp[i-1][j] + dp[i][j-1]
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int origin = obstacleGrid[0][0];
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 1) {
                    //受影响的格子也置为0
                    obstacleGrid[i][0] = 0;
                    if (i + 1 < m) {
                        obstacleGrid[i + 1][0] = 1;
                    } else {
                        break;
                    }
                }else {
                    obstacleGrid[i][0] = 1;
                }

            }

            for (int j = 0; j < n; j++) {
                obstacleGrid[0][0] = origin;
                if (obstacleGrid[0][j] == 1) {
                    //受影响的格子也置为0
                    obstacleGrid[0][j] = 0;
                    if (j + 1 < n) {
                        obstacleGrid[0][j + 1] = 1;
                    } else {
                        break;
                    }
                }else {
                    obstacleGrid[0][j] = 1;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }
                }
            }
            return obstacleGrid[m - 1][n - 1];
        }
    }


    public static void main(String[] args) {
        UniquePathsWithObstacles.Solution solution = new UniquePathsWithObstacles().new Solution();
        int[][] grid = new int[3][3];
        grid[0][0] = 0;
        grid[0][1] = 1;
        grid[0][2] = 0;
        grid[1][0] = 1;
        grid[1][1] = 0;
        grid[1][2] = 0;
        grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 0;
        solution.uniquePathsWithObstacles(grid);
    }
}
