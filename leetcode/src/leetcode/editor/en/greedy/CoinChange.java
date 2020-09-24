package leetcode.editor.en.greedy;

import java.util.Arrays;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-24 15:58
 */
public class CoinChange {

    //You are given coins of different denominations and a total amount of money amo
//unt. Write a function to compute the fewest number of coins that you need to mak
//e up that amount. If that amount of money cannot be made up by any combination o
//f the coins, return -1.
//
// Example 1:
//
//
//Input: coins = [1, 2, 5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//
// Example 2:
//
//
//Input: coins = [2], amount = 3
//Output: -1
//
//
// Note:
//You may assume that you have an infinite number of each kind of coin.
// Related Topics Dynamic Programming


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = Integer.MAX_VALUE;

        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            Change(coins, coins.length - 1, amount, 0);
            return ans == Integer.MAX_VALUE ? -1 : ans;

        }

        /**
         *
         * @param coins 零钱数组
         * @param index 零钱下标
         * @param amount 总额
         * @param cnt 返回结果
         */
        public void Change(int[] coins, int index, int amount, int cnt) {
            if (index < 0) {
                return;
            }
            // 倒序遍历 最大值在最后
            for (int c = amount / coins[index]; c >= 0; c--) {
                int na = amount - c * coins[index];
                //返回的数量
                int ncnt = cnt + c;
                if (na == 0) {
                    ans = Math.min(ans, ncnt);
                    break;//剪枝1
                }
                if (ncnt + 1 >= ans) {
                    break; //剪枝2
                }
                Change(coins, index - 1, na, ncnt);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
