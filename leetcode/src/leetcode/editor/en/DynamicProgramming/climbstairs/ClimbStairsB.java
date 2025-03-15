package leetcode.editor.en.DynamicProgramming.climbstairs;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-12 21:16
 */
public class ClimbStairsB {

    class solution1 {
        public int climbStairs(int n) {

            if (n < 3) {
                return n;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    class solution2 {

        public int climbStairs(int n) {
            return Fibonacci(n, 1, 1);
        }

        private int Fibonacci(int n, int i, int j) {
            if (n <= 1) return j;
            return Fibonacci(n - 1, j, i + j);
        }
    }

    /**
     * 数学归纳法 滚动数组思想
     */
    class solution3 {

        public int climbStairs(int n) {

            int fna = 0;
            int fnb = 0;
            int r = 1;
            for (int i = 1; i <= n; i++) {
                fna = fnb;
                fnb = r;
                r = fnb + fna;
            }
            return r;

        }
    }

    /**
     * 动态规划
     */
    class solution4 {

        public int climbStairs(int n) {
            //该数组每个元素的指针对应的是台阶数,元素的值存放的是台阶数对应的方法数
            int[] dp = new int[n + 2];
            //1阶台阶,只有一种方式(1)
            dp[1] = 1;

            //2阶台阶,有两种方式(1+1, 2), 因为题目设定n是正整数,所以n最小是1,此时如果定义dp的长度是int[n + 1],则length=2
            //而dp[2]实际对应的是第三个元素,超出length了,所以定义new int[n + 2]更合理
            dp[2] = 2;

            //从第三个台阶开始遍历,第三个台阶,是第二个台阶的方法和第一个台阶的方法之和
            //第四个台阶,是第三个台阶和第二个台阶方法之和,依此论推....
            for (int i = 3; i <= n; i++) { //要遍历到第n个台阶,所以指针其实是从0到n,所以dp数组数量比n多1
                dp[i] = dp[i - 1] + dp[i - 2]; //最后到第n个台阶,得到结果后正好遍历完
            }

            return dp[n];
        }
    }
}
