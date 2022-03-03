package leetcode.editor.en.DynamicProgramming;

import java.util.Arrays;

/**
 * @author Hermione.lai
 * @date 2022/3/2 8:44 PM
 */
public class CoinChangeWrong {

    /**
     * // Example 1:
     * //
     * //
     * //Input: coins = [1,2,5], amount = 11
     * //Output: 3
     * //Explanation: 11 = 5 + 5 + 1
     * //
     * //
     * // Example 2:
     * //
     * //
     * //Input: coins = [2], amount = 3
     * //Output: -1
     * //
     * //
     * // Example 3:
     * //
     * //
     * //Input: coins = [1], amount = 0
     * //Output: 0
     */
    class Solution {
        /**
         * wrong answer！！！！！ how to make it right???
         * 会有错误情况覆盖不到：考虑到有 [1,7,10] 这种用例，按照贪心思路 10 + 1 + 1 + 1 + 1 会比 7 + 7 更早找到；
         * 所以还得遍历再判断
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {

            Arrays.sort(coins);
            int count = 0;
            for (int i = coins.length - 1; i >= 0; i--) {
                while (coins[i] <= amount){
                    amount -= coins[i];
                    count++;
                }
            }
            if (amount >= 1){
                return -1;
            }
            return count;
        }
    }
}
