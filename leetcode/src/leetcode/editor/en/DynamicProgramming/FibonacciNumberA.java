package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai@tuya.com
 * @date 2022/1/24 9:41 PM
 */
public class FibonacciNumberA {

    //The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
//Fibonacci sequence, such that each number is the sum of the two preceding ones,
//starting from 0 and 1. That is,
//
//
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
//
//
// Given n, calculate F(n).
//
//
// Example 1:
//
//
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//
//
// Example 2:
//
//
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//
//
// Example 3:
//
//
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
//
//
//
// Constraints:
//
//
// 0 <= n <= 30
//
// Related Topics Math Dynamic Programming Recursion Memoization 👍 2727 👎 252


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int fib2(int n) {
            if (n <= 1){
                return n;
            }
            int a = 0;
            int b = 1;
            int c = 0;
            for (int i = 2; i < n + 1; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }

        public int fib1(int n) {
            return combineBruteForce(n);
        }

        public int combineBruteForce(int n){
            if (n <= 1){
                return n;
            }
            return combineBruteForce(n-1) + combineBruteForce(n-2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
