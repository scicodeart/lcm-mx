package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai@tuya.com
 * @date 2022/3/2 10:37 PM
 */
public class HouseRobberI {

    class Solution {

        /**
         * [0]：不偷
         * [1]：偷
         * <p>
         * a[i][0] = max(a[i-1][0],a[i-1][1])
         * a[i][1] = a[i-1][0] + num[i]
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {

            if (nums == null || nums.length == 0) {
                return 0;
            }

            int n = nums.length;
            int[][] a = new int[n][2];

            a[0][0] = 0;
            a[0][1] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                //i do not robber
                a[i][0] = Math.max(a[i - 1][0], a[i - 1][1]);

                //i do robber
                a[i][1] = a[i - 1][0] + nums[i];
            }
            return Math.max(a[n - 1][0], a[n - 1][1]);
        }
    }

}
