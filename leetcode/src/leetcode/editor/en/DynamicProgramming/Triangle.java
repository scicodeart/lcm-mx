package leetcode.editor.en.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Hermione.lai
 * @date 2022/2/21 10:55 PM
 */
public class Triangle {


    class Solution {

        // 递归
        public int minimumTotalByBruteForce(List<List<Integer>> triangle) {
            //递归
            return dfs(triangle, 0, 0);
        }

        private int dfs(List<List<Integer>> triangle, int i, int j) {
            if (i == triangle.size()) {
                return 0;
            }
            return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        }

        // 自底向上递归
        public int minimumTotal(List<List<Integer>> triangle) {

            //递推公式 f[i][j] = min(f[i+1,j],f[i][j]) + a[i,j]
            int high = triangle.size();
            int maxLength = triangle.get(high - 1).size();

            int[][] dp = new int[high + 1][maxLength + 1];
            for (int i = 0; i < maxLength; i++) {
                dp[high - 1][i] = triangle.get(high - 1).get(i);
            }

            //从倒数第二行开始计算
            for (int i = high - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }

        //优化版
        public int minimumTotalOpt(List<List<Integer>> triangle) {

            //递推公式 f[i][j] = min(f[i+1,j],f[i][j]) + a[i,j]
            int high = triangle.size();

            //初始化空间留一行，以防溢出
            int[][] dp = new int[high + 1][high + 1];
            //从倒数第二行开始计算
            for (int i = high - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }
    }

    public static void main(String[] args) {
        Triangle.Solution solution = new Triangle().new Solution();
        List<List<Integer>> total = new ArrayList<>();
        List<Integer> a = Collections.singletonList(2);
        List<Integer> b = Arrays.asList(3, 4);
        List<Integer> c = Arrays.asList(6, 5, 7);
        List<Integer> d = Arrays.asList(4, 1, 8, 3);
        total.add(a);
        total.add(b);
        total.add(c);
        total.add(d);
        solution.minimumTotal(total);
    }
}
