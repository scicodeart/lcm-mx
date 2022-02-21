package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai
 * @date 2022/2/20 10:14 PM
 */
public class LongestCommonSubSequenceI {
    class Solution {

        /**
         * if (text[i] == text[j])
         * dp[i][j] = dp[i - 1][j - 1] + 1;
         * else
         * dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
         *
         * @param text1
         * @param text2
         * @return
         */
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            if (m == 0 || n == 0) {
                return 0;
            }

            //考虑等式要用到i-1
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    //为什么是i-1和j-1 ： dp二维数组冗余了一个0空间在i=0和j=0的时候
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
