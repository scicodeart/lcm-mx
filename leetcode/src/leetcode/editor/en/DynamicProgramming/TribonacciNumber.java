package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai
 * @date 2022/2/21 10:12 PM
 */
public class TribonacciNumber {

    /**
     * // T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
     */
    class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n <= 2) {
                return 1;
            }
            int p = 0, q = 0, r = 1, s = 1;
            for (int i = 3; i <= n; ++i) {
                p = q;
                q = r;
                r = s;
                s = p + q + r;
            }
            return s;
        }
    }
}
