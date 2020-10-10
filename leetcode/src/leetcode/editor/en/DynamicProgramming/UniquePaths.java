package leetcode.editor.en.DynamicProgramming;

/**
 * 计算总共有多少条路径
 *
 * @author Lai
 * @version 1.0
 * @date 2020-10-10 19:08
 */
public class UniquePaths {


//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 问总共有多少条不同的路径？
//
//
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？
//
//
//
// 示例 1:
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
//
//
// 示例 2:
//
// 输入: m = 7, n = 3
//输出: 28
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 10 ^ 9
//
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

    /**
     * 思路二：动态规划
     *
     * 我们令 dp[i][j] 是到达 i, j 最多路径
     *
     * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * 注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
     *
     * 时间复杂度：O(m*n)O(m∗n)
     *
     * 空间复杂度：O(m * n)O(m∗n)
     *
     * 优化：因为我们每次只需要 dp[i-1][j],dp[i][j-1]
     *
     * 所以我们只要记录这两个数，直接看代码吧！
     *
     * 作者：powcai
     * 链接：https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        //第一行和第一列都只有一种走法
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
