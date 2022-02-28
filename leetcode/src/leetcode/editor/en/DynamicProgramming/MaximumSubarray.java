package leetcode.editor.en.DynamicProgramming;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/solution/
 *
 * @author Lai
 * @version 1.0
 * @date 2020-09-24 19:39
 */
public class MaximumSubarray {

    class Solution {
        public int maxSubArray(int[] nums) {
            // sum > 0 sum+
            // sum < 0 choose the next
            // save the result every run and compare the max
            int result = nums[0];
            int sum = 0;
            for (int num : nums) {
                if (sum > 0) {
                    sum += num;
                } else {
                    sum = num;
                }
                result = Math.max(result, sum);
            }
            return result;
        }
    }

}
