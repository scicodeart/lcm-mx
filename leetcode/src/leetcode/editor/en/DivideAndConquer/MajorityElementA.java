package leetcode.editor.en.DivideAndConquer;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-20 21:21
 */
public class MajorityElementA {

    class Solution {

        /**
         * 分治法
         *
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            return majorityElementRec(nums, 0, nums.length-1);

        }

        private int majorityElementRec(int[] nums, int lo, int hi) {
            if (lo == hi) {
                return nums[lo];
            }

            // recurse on left and right halves of this slice.
            int mid = (hi-lo)/2 + lo;
            int left = majorityElementRec(nums, lo, mid);
            int right = majorityElementRec(nums, mid+1, hi);

            // if the two halves agree on the majority element, return it.
            if (left == right) {
                return left;
            }

            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, lo, hi);
            int rightCount = countInRange(nums, right, lo, hi);

            return leftCount > rightCount ? left : right;
        }

        private int countInRange(int[] nums, int num, int lo, int hi) {
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }
    }

}
