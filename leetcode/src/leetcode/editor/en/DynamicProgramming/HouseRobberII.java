package leetcode.editor.en.DynamicProgramming;

/**
 * @author Hermione.lai
 * @date 2022/3/5 9:43 PM
 */
public class HouseRobberII {
    class Solution {
        /**
         * 213
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {

            /**
             * 环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，因此可以把此环状排列房间问题约化为两个单排排列房间子问题：
             * 在不偷窃第一个房子的情况下（即 nums[1:]nums[1:]），最大金额是 p1
             * 在不偷窃最后一个房子的情况下（即 nums[:n-1]nums[:n−1]），最大金额是 p2
             * 为以上两种情况的较大值，即 max(p1,p2) .
             */
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            } else if (length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
        }

        public int robRange(int[] nums, int start, int end) {
            int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i <= end; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }
}
