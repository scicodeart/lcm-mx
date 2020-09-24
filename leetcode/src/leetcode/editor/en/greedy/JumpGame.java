package leetcode.editor.en.greedy;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-20 18:22
 */
public class JumpGame {

    //Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array.
//
// Each element in the array represents your maximum jump length at that positio
//n.
//
// Determine if you are able to reach the last index.
//
//
// Example 1:
//
//
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 10^4
// 0 <= nums[i][j] <= 10^5
//
// Related Topics Array Greedy


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null) return false;
            int y = nums.length - 1;
            for (int i = y; i>= 0  ; i--) {
                if (nums[i]+ i >= y){
                    y = i;
                }
            }
            return y == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
