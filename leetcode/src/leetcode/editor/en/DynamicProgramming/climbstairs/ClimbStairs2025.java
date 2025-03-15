package leetcode.editor.en.DynamicProgramming.climbstairs;

public class ClimbStairs2025 {

    /**
     * 找最近重复子问题
     * 三级台阶是从二级台阶跨一步走上来的
     * 1:1
     * 2:2
     * 3:f(1)+f(2)
     * 4:f(3)+f(2)
     * f(n)=f(n-1)+f(n-2) 斐波那契数列
     */
    class Solution {
        /**
         * 只需要最初的三个值，然后不断累加累加
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int a = 1;
            int b = 2;
            int c = a + b;
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
