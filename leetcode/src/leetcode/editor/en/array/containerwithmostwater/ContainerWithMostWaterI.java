package leetcode.editor.en.array.containerwithmostwater;

/**
 * @author Hermione.lai
 * @date 2022/3/8 8:52 PM
 */
public class ContainerWithMostWaterI {

    class Solution {
        //往里推进的时候，重点在于高，而不是宽
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int max = 0;
            while (i < j) {
                if (height[i] < height[j]) {
                    max = Math.max(max, (j - i) * height[i]);
                    i++;
                } else {
                    max = Math.max(max, (j - i) * height[j]);
                    j--;
                }
            }
            return max;
        }
    }

    public int maxAreaTest1(int[] height) {

        //向内收拢遍历，双指针，如果往里更大，则往里移动
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            //explore i++
            if (height[i] < height[j]) {
                maxArea = Math.max(maxArea, (j - i) * height[i]);
                i++;
            } else {
                maxArea = Math.max(maxArea, (j - i) * height[j]);
                j--;
            }
        }
        return maxArea;
    }
}
