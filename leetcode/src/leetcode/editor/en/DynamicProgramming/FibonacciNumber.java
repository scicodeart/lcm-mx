package leetcode.editor.en.DynamicProgramming;


/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-10 17:06
 */
public class FibonacciNumber {
    class Solution {
        public int fib(int N) {
            if (N <= 1) return N;
            return fib(N - 1) + fib(N - 2);
        }
    }

    class SolutionDB {
        public int fib(int N) {
            int[] a = new int[N + 2];
            a[0] = 0;
            a[1] = 1;
            for (int i = 2; i <= N; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
            return a[N];
        }
    }
}
