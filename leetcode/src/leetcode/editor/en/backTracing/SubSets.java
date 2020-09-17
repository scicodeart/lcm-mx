package leetcode.editor.en.backTracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-14 19:49
 */
public class SubSets {
    //Given a set of distinct integers, nums, return all possible subsets (the power
// set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics Array Backtracking Bit Manipulation


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 递归
     */
    class Solution1 {
        public List<List<Integer>> subsets(int[] nums) {
            // result
            List<List<Integer>> output = new ArrayList();
            output.add(new ArrayList<Integer>());

            //
            for (int num : nums) {
                List<List<Integer>> newSubsets = new ArrayList();
                for (List<Integer> curr : output) {
                    newSubsets.add(new ArrayList<Integer>(curr){
                        { add(num); }
                    });
                }
                for (List<Integer> curr : newSubsets) {
                    output.add(curr);
                }
            }
            return output;
        }
    }

    /**
     * 回溯
     */
    class Solution2 {
        List<List<Integer>> output = new ArrayList();
        int n, k;

        public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
            // if the combination is done
            if (curr.size() == k)
                output.add(new ArrayList(curr));

            for (int i = first; i < n; ++i) {
                // add i into the current combination
                curr.add(nums[i]);
                // use next integers to complete the combination
                backtrack(i + 1, curr, nums);
                // backtrack
                curr.remove(curr.size() - 1);
            }
        }

        /**
         * 解题
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets(int[] nums) {

            n = nums.length;
            for (k = 0; k < n + 1; ++k) {
                backtrack(0, new ArrayList<>(), nums);
            }
            return output;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
