package leetcode.editor.en.DynamicProgramming;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-10 19:30
 */
public class MinimumPathSum {
    //给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
// Related Topics 数组 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {

            int m = grid.length;
            if (m == 0) return 0;
            int n = grid[0].length;
            int[][] result = new int[m][n];
            result[0][0] = grid[0][0];

            //初始化第一行和第一列
            for (int i = 1; i < m; i++) {
                result[i][0] = result[i - 1][0] + grid[i][0];
            }
            for (int j = 1; j < n; j++) {
                result[0][j] = result[0][j - 1] + grid[0][j];
            }


            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    result[i][j] =  Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
                }
            }
            return result[m - 1][n - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
