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
                    if (profit > 0 && profit > max){
                        max = profit;
                    }
                }
            }
            return max;
        }
    }

    class SolutionB {
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                //因为最大值必须在最小值后面，所以
                if (prices[i] < min) {
                    min = prices[i];
                }
                if (prices[i] - min > max){
                    max = prices[i] - min;
                }
            }
            return max;
        }
    }
}
