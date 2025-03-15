//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target.
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice.
//
// Example:
//
//
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
//
// Related Topics array Hash Table

package leetcode.editor.en.Hash.twosum;


import java.util.Arrays;
import java.util.HashMap;


public class TwoSum{

    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] nums = {3,3};
        int[] ints = solution.twoSum(nums, 6);
        System.out.println(Arrays.toString(ints));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],i);
            }
            for (int i = 0; i < nums.length; i++) {
                int b = target - nums[i];

                if (map.containsKey(b) && map.get(b)!=i){
                    result[0] = i;
                    result[1] = map.get(b);
                    return result;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}