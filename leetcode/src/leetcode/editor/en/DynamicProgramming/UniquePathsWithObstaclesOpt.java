package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai@tuya.com
 * @date 2022/2/20 6:37 PM
 */
public class UniquePathsWithObstaclesOpt {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            //用一个数组承接，比较方便
            int[][] dp = new int[m][n];
            //处理边界问题
            dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

            //处理第一行和第一列问题，一旦有障碍物，则后面的
            for (int i = 1; i < m; i++) {
                //表示如果上一个dp空间也是0，则后面的也为0
                if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = 1;
                }
            }

            for (int j = 1; j < n; j++) {
                if (obstacleGrid[0][j] == 1 || dp[0][j - 1] == 0) {
                    dp[0][j] = 0;
                } else {
                    dp[0][j] = 1;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    //如果当前格子是障碍物
                    if(obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                        //路径总数来自于上方(dp[i-1][j])和左方(dp[i][j-1])
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }
}
