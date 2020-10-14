package leetcode.editor.en.DynamicProgramming;

import java.util.List;

/**
 *
 * 120 三角形最小路径和
 *
 * @author Lai
 * @version 1.0
 * @date 2020-10-14 17:57
 */
public class TriangleDescription {
    //给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.brute force n层递归 暴力
         * 2.DP 缓存子结果：
         * 1.重复性
         * 2.定义状态数组  f（i，j）
         * 3.dp方程 f（i，j） = min( f((i+1),j) , f(i+1,j+1) ) + a(i,j)
         *
         * @param triangle
         * @return
         */
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
            int[][] dp = new int[n + 1][n + 1];
            // 从三角形的最后一行开始递推。
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    //最小值加上当前值
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }
    }

    /**
     * 空间优化
     */
    class Solution2 {
        /**
         * 1.brute force n层递归 暴力
         * 2.DP 缓存子结果：
         * 1.重复性
         * 2.定义状态数组  f（i，j）
         * 3.dp方程 f（i，j） = min( f((i+1),j) , f(i+1,j+1) ) + a(i,j)
         *
         * @param triangle
         * @return
         */
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] f = new int[n];

            f[0] = triangle.get(0).get(0);

            for (int i = 1; i < n; ++i) {
                f[i] = f[i - 1] + triangle.get(i).get(i);
                for (int j = i - 1; j > 0; --j) {
                    f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
                }
                f[0] += triangle.get(i).get(0);
            }
            int minTotal = f[0];
            for (int i = 1; i < n; ++i) {
                minTotal = Math.min(minTotal, f[i]);
            }
            return minTotal;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 空间优化
     */
    class Solution3 {
        /**
         * 递归
         *
         * @param triangle
         * @return
         */
        public int minimumTotal(List<List<Integer>> triangle) {

        }
    }

}
