package leetcode.editor.en.DynamicProgramming;

/**
 * 爬楼梯变种：不能连续走相邻的两步
 *
 * @author Lai
 * @version 1.0
 * @date 2020-10-14 16:36
 */
public class ClimbStairsByteDance {

    class solution {
        public int climbStairs(int n) {
            int[][] v = new int[n+1][2];
            // v[i][0]表示上一跳为1级时，剩余i级台阶有v[i][0]种跳法
            // v[i][1]表示上一跳为2级时，剩余i级台阶有v[i][1]种跳法
            v[1][0] = 1;
            v[1][1] = 1;

            if (n >= 2) {
                v[2][0] = 2;
                v[2][1] = 1;
            }
            for (int i = 3; i <= n; ++i) {
                v[i][0] = v[i - 1][0] + v[i - 2][1];
                v[i][1] = v[i - 1][0];
            }
            return v[n][0];
        }
    }
}
