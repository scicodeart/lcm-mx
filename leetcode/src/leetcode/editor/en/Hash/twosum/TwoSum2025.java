package leetcode.editor.en.Hash.twosum;

import java.util.HashMap;

public class TwoSum2025 {

    class Solution {
        /**
         * 1.数组存入哈希表
         * 2.判断差值是否在哈希表
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                //会有个边界情况：两个值相同的情况，所以趁着第二个值还没存入到哈希表，就直接返回
                if (map.containsKey(target - nums[i])) {
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                }
                map.put(nums[i], i);
            }
            return res;
        }
    }
}
