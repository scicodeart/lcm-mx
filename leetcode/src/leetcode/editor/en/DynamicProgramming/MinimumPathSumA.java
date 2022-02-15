package leetcode.editor.en.DynamicProgramming;

/**
 * @author
 * @date 2022/2/15 5:42 PM
 */
public class MinimumPathSumA {

    //Given a m x n grid filled with non-negative numbers, find a path from top
//left to bottom right, which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
//
// Example 1:
//
//
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
//
//
// Example 2:
//
//
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics Array Dynamic Programming Matrix 👍 6705 👎 92


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 递推累加，找出递推状态最小值
         *
         * @param grid
         * @return
         */
        public int minPathSumByBruteForce(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] sum = new int[m][n];
            //第一位赋值
            sum[0][0] = grid[0][0];

            //第一行和第一列初始化累加
            for (int i = 1; i < n; i++) {
                sum[0][i] = sum[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < m; i++) {
                sum[i][0] = sum[i - 1][0] + grid[i][0];
            }

            //递推公式
            for (int i = 1; i <= m - 1; i++) {
                for (int j = 1; j <= n - 1; j++) {
                    sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
                }
            }
            return sum[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {
        MinimumPathSumA.Solution solution = new MinimumPathSumA().new Solution();
        int[][] grid = new int[3][1];
        grid[0][0] = 1;
        grid[1][0] = 3;
        grid[2][0] = 1;
//        int sum = 0;
//        for (int i = 0; i < 3; i++) {
//            sum += 2;
//            System.out.println(sum);
//        }

        solution.minPathSumByBruteForce(grid);

    }
//leetcode submit region end(Prohibit modification and deletion)

}
