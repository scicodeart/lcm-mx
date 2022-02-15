package leetcode.editor.en.DynamicProgramming;

/**
 * @author
 * @date 2022/2/15 10:17 PM
 */
public class UniquePaths1 {

    //There is a robot on an m x n grid. The robot is initially located at the top-
//left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right
//corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at
//any point in time.
//
// Given the two integers m and n, return the number of possible unique paths
//that the robot can take to reach the bottom-right corner.
//
// The test cases are generated so that the answer will be less than or equal
//to 2 * 10⁹.
//
//
// Example 1:
//
//
//Input: m = 3, n = 7
//Output: 28
//
//
// Example 2:
//
//
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach
//the bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 100
//
// Related Topics Math Dynamic Programming Combinatorics 👍 7953 👎 280


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {

            //m*n矩阵
            int[][] matrix = new int[m][n];

            //分治算法：根据动态转移方程，从终点往前开始递推 int[0][0] 的值
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    //从只有1种路径的格子开始往前递推 int[m-1][j] int[i][n-1]都只有1种办法
                    if (i == m - 1 || j == n - 1) {
                        matrix[i][j] = 1;
                    } else {
                        //状态转移方程关键
                        matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
                    }
                }
            }
            return matrix[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
