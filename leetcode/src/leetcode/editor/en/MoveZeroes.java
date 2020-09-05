package leetcode.editor.en;

public class MoveZeroes {

    //Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements.
//
// Example:
//
//
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]
//
// Note:
//
//
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
// Related Topics array Two Pointers


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 1. move the numbers(excluded zero) to the beginning of the array
         *
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    //only when nums[i] != 0 ,then move the non-zero numbers to the beginning
                    nums[j] = nums[i];
                    if (i != j) {
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }

        /**
         * 1. move the numbers(excluded zero) to the beginning of the array
         *
         * @param nums
         */
        public void moveZeroesSecondMethod(int[] nums) {
            int j = 0;
            // move the non-zero numbers to the beginning
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }

            // make the remain space = zero
            for (int i = j; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
