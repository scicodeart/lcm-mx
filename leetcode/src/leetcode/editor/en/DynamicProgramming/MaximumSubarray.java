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
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }

}
