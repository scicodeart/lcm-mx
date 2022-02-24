package leetcode.editor.en.DynamicProgramming;

import java.util.List;

/**
 * @author Hermione.lai
 * @date 2022/2/21 10:55 PM
 */
public class Triangle {


    class Solution {

        public int minimumTotalByBruteForce(List<List<Integer>> triangle) {
            //递归
            return 1;

        }


        public int minimumTotal(List<List<Integer>> triangle) {

            //递推公式 f[i][j] = min(f[i+1,j],f[i][j+1]) + a[i,j]
            int high = triangle.size();
            //这一步其实是有数字的
            int maxLength = triangle.get(high - 1).size();
            int[][] dp = new int[high][maxLength];
            for (int i = high - 1; i <= high; i--) {
                for (int j = 0; j < high; j++) {

                }
            }
            return triangle.get(0).get(0);
        }
    }
}
