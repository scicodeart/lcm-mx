package leetcode.editor.en;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock{
//Say you have an array for which the ith element is the price of a given stock
//on day i.
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t.
//
// Note that you cannot sell a stock before you buy one.
//
// Example 1:
//
//
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
//
//
// Example 2:
//
//
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
// Related Topics Array Dynamic Programming


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 暴力破解法
         * @param prices
         * @return
         */
        public int maxProfit1(int[] prices) {

            int maxprofit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int profit = prices[j] - prices[i];
                    if (profit > maxprofit){
                        maxprofit = profit;
                    }

                }
            }
            return maxprofit;

        }

        /**
         * 技巧篇，保证最低点在最高点的前面  时间复杂度：O(N)
         * @param prices
         * @return
         */
        public int maxProfit2(int[] prices) {


            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            int maxProfit = 0;
            int minValue = prices[0];
            for (int i = 1; i < prices.length; i++) {
                //找出最大值，然后反差
                maxProfit = Math.max(prices[i]-minValue,maxProfit);
                //找出最小值
                minValue = Math.min(minValue, prices[i]);
            }
            return maxProfit;
        }


        /**
         * 动态规划
         *
         * “动态规划”用于多阶段最优化问题的求解。这里天数代表每个阶段，即一天一天看，设置为第一维。
         * 为了消除后效性（前面的状态确定下来以后不会因为后面状态而更改），将当天是否持股设置为第二维的状态。
         *
         * 状态 dp[i][j] 表示：在索引为 i 的这一天，用户手上持股状态为 j 所获得的最大利润。
         *
         * 说明：
         * j 只有 2 个值：0 表示不持股（特指卖出股票以后的不持股状态），1 表示持股。
         * “用户手上不持股”不代表用户一定在索引为 i 的这一天把股票抛售了；
         *
         * @param prices
         * @return
         */
        public int maxProfit3(int[] prices) {

            int len = prices.length;
            if (len < 2) {
                return 0;
            }
            // 0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，非指没有进行过任何交易的不持股
            // 1：用户手上持股所能获得的最大利润

            // 注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
            int[][] dp = new int[len][2];  //限制数字
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[len - 1][0];
        }
    }



    public static void main(String[] args) {
        BestTimeToBuyAndSellStock.Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        int[] a = {2,5,3,4,6,7,9};
        System.out.println(solution.maxProfit1(a));
    }

//leetcode submit region end(Prohibit modification and deletion)

}