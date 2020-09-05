package leetcode.editor.en.array;

public class ContainerWithMostWater {
    //Given n non-negative integers a1, a2, ..., an , where each represents a point
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis for
//ms a container, such that the container contains the most water.
//
// Note: You may not slant the container and n is at least 2.
//
//
//
//
//
// The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In thi
//s case, the max area of water (blue section) the container can contain is 49.
//
//
//
// Example:
//
//
//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49 Related Topics array Two Pointers


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1. 枚举 （x-y）* height O(n^2)
         * 2. O(n) 左右边界i，j，向中间熟练
         *
         * @param height
         * @return
         */
        public int maxArea1(int[] height) {

            int max = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int area = (j - i) * Math.min(height[i], height[j]);
                    max = Math.max(max, area);
                }
            }
            return max;
        }


        /**
         * 最优算法
         *
         * @param height
         * @return
         */
        public int maxArea2(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int max = 0;
            while (i < j) {
                int minHeight = height[i] < height[j] ? height[i++] : height[j--];
                int area = (j - i + 1) * minHeight;
                max = Math.max(max, area);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
