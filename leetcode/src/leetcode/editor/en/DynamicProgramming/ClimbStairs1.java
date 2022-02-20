package leetcode.editor.en.DynamicProgramming;

/**
 * @author
 * @date 2022/1/5 2:21 下午
 */
public class ClimbStairs1 {


//You are climbing a staircase. It takes n steps to reach the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can
//you climb to the top?
//
//
// Example 1:
//
//
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//
// Example 2:
//
//
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
//
//
// Constraints:
//
//
// 1 <= n <= 45
//
// Related Topics Math Dynamic Programming Memoization 👍 10117 👎 309


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairsBruteForce(int n) {
            if (n <= 2) {
                return n;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }

        /**
         * 斐波那契数列
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            int a = 1;
            int b = 2;

            if (n == 1) {
                return a;
            }
            if (n == 2) {
                return b;
            }
            int c = 0;
            for (int i = 3; i < n + 1; i++) {
                c = a + b;
                a = b;
                b = c;

            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
