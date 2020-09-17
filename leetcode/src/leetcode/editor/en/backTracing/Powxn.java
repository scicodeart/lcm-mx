package leetcode.editor.en.backTracing;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-14 18:04
 */
public class Powxn {

    //Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
//
//
// Example 1:
//
//
//Input: x = 2.00000, n = 10
//Output: 1024.00000
//
//
// Example 2:
//
//
//Input: x = 2.10000, n = 3
//Output: 9.26100
//
//
// Example 3:
//
//
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
//
//
//
// Constraints:
//
//
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xn <= 104
//
// Related Topics Math Binary Search


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 字节跳动面试题
         * <p>
         * 方法一：快速幂 + 递归
         * 「快速幂算法」的本质是分治算法。举个例子，如果我们要计算 x^{64}
         * 根据递归计算的结果，如果 nn 为偶数，那么 x^n = y^2   如果 nn 为奇数，那么 x^n = y^2 * x
         * 递归的边界为 n = 0，任意数的 0 次方均为 11。
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            //考虑负数可能越界问题
            long N = n;

            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);

        }

        public double quickMul(double x, long n) {

            if (n == 0) return 1;

            double y = quickMul(x, n / 2);

            return n % 2 == 0 ? y * y : y * y * x;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
