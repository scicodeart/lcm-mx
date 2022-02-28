package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai
 * @date 2022/2/27 4:47 PM
 */
public class MaximumSubarrayI {

    class Solution {
        public int maxSubArrayBruteForce(int[] nums) {
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                if (temp > max) {
                    max = temp;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    temp += nums[j];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
            return max;
        }

        /**
         * 最大子数组和 = 当前元素最大，或者 包含之前元素为最大。（关键点）
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int pre = 0;
            int max = nums[0];

            for (int i = 0; i < nums.length; i++) {
                //包含之前元素，往后比较
                pre = Math.max(nums[i], pre + nums[i]);
                max = Math.max(pre, max);
            }
            return max;
        }
    }
}
