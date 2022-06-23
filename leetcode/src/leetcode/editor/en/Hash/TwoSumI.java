package leetcode.editor.en.Hash;

import java.util.HashMap;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-06-23 15:18
 */
public class TwoSumI {

    class Solution {
        public int[] twoSum(int[] nums, int target) {


            HashMap<Integer, Integer> map = new HashMap();

            for (int i = 0; i < nums.length; i++) {
                int another = target - nums[i];
                if (map.containsKey(another)) {
                    return new int[]{i, map.get(another)};
                } else {
                    map.put(nums[i], i);
                }
            }
            return null;
        }
    }
}
