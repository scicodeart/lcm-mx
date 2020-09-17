package leetcode.editor.en.DynamicProgramming;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-15 18:52
 */
public class ClimbStairsC {

    class Solution1 {
        public int climbStairs(int n) {


            if (n <= 2) {
                return n;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    class Solution2 {
        public int climbStairs(int n) {


            int[] dp = new int[n + 2];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {

                dp[i] = dp[i-1] + dp[i-2];
            }

            return dp[n];

        }


    }
}
