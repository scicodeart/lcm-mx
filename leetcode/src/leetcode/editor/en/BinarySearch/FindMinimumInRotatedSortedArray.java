package leetcode.editor.en.BinarySearch;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-07 23:16
 */
public class FindMinimumInRotatedSortedArray {
    //Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.
//
// Example 1:
//
//
//Input: [3,4,5,1,2]
//Output: 1
//
//
// Example 2:
//
//
//Input: [4,5,6,7,0,1,2]
//Output: 0
//
// Related Topics Array Binary Search


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 1、暴力：还原升序 o（n），然后再二分查找
         * 2、直接二分查找
         * 单调
         * 边界
         *
         * @param nums
         * @return
         */
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
