package leetcode.editor.en.Hash;

import java.util.HashMap;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-11 20:35
 */
public class TwoSumC {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])){
                    // 以免重复使用某数据
                    if(i!=map.get(target - nums[i])){
                        return new int[]{i,map.get(target - nums[i])};
                    }
                }
            }
            return null;
        }
    }
}
