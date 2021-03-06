package leetcode.editor.en.DynamicProgramming;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-26 01:29
 */
public class LongestCommonSubsequence {
    //Given two strings text1 and text2, return the length of their longest common s
//ubsequence.
//
// A subsequence of a string is a new string generated from the original string
//with some characters(can be none) deleted without changing the relative order of
// the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is
// not). A common subsequence of two strings is a subsequence that is common to bo
//th strings.
//
//
//
// If there is no common subsequence, return 0.
//
//
// Example 1:
//
//
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.
//
//
// Example 2:
//
//
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
//
//
// Example 3:
//
//
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
//
//
//
// Constraints:
//
//
// 1 <= text1.length <= 1000
// 1 <= text2.length <= 1000
// The input strings consist of lowercase English characters only.
//
// Related Topics Dynamic Programming


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 获取两个串字符
                    char c1 = text1.charAt(i), c2 = text2.charAt(j);

                    if (c1 == c2) {
                        // 去找它们前面各退一格的值加1即可
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    } else {
                        //要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
            return dp[m][n];

        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}
