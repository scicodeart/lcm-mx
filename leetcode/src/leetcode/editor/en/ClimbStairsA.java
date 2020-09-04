package leetcode.editor.en;

public class ClimbStairsA {

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
         * 1 暴力是否可行
         * 2 基本情况：
         * 1：1
         * 2：2
         * 3：f(1) + f(2)
         * 4：f(2) + f(3)
         * <p>
         * f(n) = f(n-1) + f(n-2) :Fibonacci
         * 找重复子问题（找重复性）
         * <p>
         * 滚动数组 动态规划 f(x)=f(x−1)+f(x−2)
         * 不需要保存所有的值，只需要不断传递最新的三个值 得出结果
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {

            if (n <= 2) {
                return n;
            }
            int f1 = 1;
            int f2 = 2;
            int f3 = 3;
            for (int i = 3; i <= n ; i++) {

                f3 = f1 + f2;
                f1 = f2;
                f2 = f3;
            }
            return f3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        ClimbStairsA.Solution solution = new ClimbStairsA().new Solution();
        System.out.println(solution.climbStairs(2));
    }


}
