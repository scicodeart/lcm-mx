package leetcode.editor.en.array.containerwithmostwater;

public class ContainerWithMostWater2025 {

    /**
     * 1. 枚举 （x-y）* height O(n^2)  = 暴力解法
     * 2. O(n) 左右边界i，j，向中间熟练
     */
    class Solution {

        /**
         * 1. 暴力解法 == 超出时间限制
         *
         * @param height
         * @return
         */
        public int maxArea1(int[] height) {
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                }
            }
            return max;

        }

        /**
         * 2. 最优算法
         * 因为求的是长*宽，可先直接选定最宽的长度，再往里慢慢收敛即可
         *
         * @param height
         * @return
         */
        public int maxArea2(int[] height) {
            int max = 0;
            for (int i = 0, j = height.length - 1; i < j; ) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                if (height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }
            }
            return max;
        }
    }
}
