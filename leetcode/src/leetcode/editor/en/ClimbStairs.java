package leetcode.editor.en;

public class ClimbStairs {

//You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top?
//
// Example 1:
//
//
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//
// Example 2:
//
//
//Input: 3
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
// Related Topics Dynamic Programming


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 滚动数组 动态规划 f(x)=f(x−1)+f(x−2)
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {

            int a = 0;
            int b = 0;
            int methodWays = 1;

            /**
             * i = 1 , 方法一种
             */
            for (int i = 1; i <= n; i++) {
                a = b;
                b = methodWays;
                methodWays = a + b;
            }
            return methodWays;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        ClimbStairs.Solution solution = new ClimbStairs().new Solution();
        System.out.println(solution.climbStairs(2));
    }


}
