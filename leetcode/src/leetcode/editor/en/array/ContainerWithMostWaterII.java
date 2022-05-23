package leetcode.editor.en.array;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-05-23 17:11
 */
public class ContainerWithMostWaterII {

    class Solution {
        public int maxArea(int[] height) {

            int max = 0;
            for (int i = 0, j = height.length - 1; i < j; ) {
                int minHeight = height[i] < height[j] ? height[i++] : height[j--];
                max = Math.max(max, minHeight * (j - i + 1));

            }
            return max;
        }
    }


    public static void main(String[] args) {
        ContainerWithMostWaterII.Solution solution = new ContainerWithMostWaterII().new Solution();
        int[] nums1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        solution.maxArea(nums1);
    }
}
