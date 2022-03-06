package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai@tuya.com
 * @date 2022/3/5 11:08 PM
 */
public class BestTimeToBuyAndSellStock2022 {

    class SolutionBruteForce {
        public int maxProfit(int[] prices) {

            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int profit = prices[j] - prices[i];
                    if (profit > 0 && profit > max) {
                        max = profit;
                    }
                }
            }
            return max;
        }
    }

    class SolutionGreedy {
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                //因为最大值必须在最小值后面，所以
                if (prices[i] < min) {
                    min = prices[i];
                }
                if (prices[i] - min > max) {
                    max = prices[i] - min;
                }
            }
            return max;
        }
    }


    class SolutionDB {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            // 特殊判断
            if (len < 2) {
                return 0;
            }
            int[][] dp = new int[len][2];

            // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
            // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

            // 初始化dp : 不持股的时候为0， 如果持股的话，减去买入的股票价格；
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                //当前不持股，要么前一天也没持股，要么前一天持股了，今天卖了，所以当前不持股，卖了的话加上今天的股价
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //当前持股，要么前一天也持股，要么前一天不持股，今天刚好买入了，则当前手中现金减去当天股价（因为此题只有一次买入情况，则当前是第一次买入）
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[len - 1][0];
        }
    }
}
