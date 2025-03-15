package leetcode.editor.en.array.threesum;

import java.util.*;

public class ThreeSum2025 {

    class Solution {
        /**
         * 1.a+b = -c
         * 2.返回不重复的数组，无序
         * 3.可能数组不存在
         * <p>
         * 思路：
         * 1. 暴力求解：三重循环
         * 2. 两重暴力+hash，把-c存在hash表里去，两重循环
         * 3. 排序后夹逼：枚举target == 双指针
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            //边界
            if (nums == null || nums.length <= 2) {
                return Collections.emptyList();
            }
            Arrays.sort(nums);
            Set<List<Integer>> result = new HashSet<>();
            for (int k = 0; k < nums.length - 2; k++) {
                //think about boundary conditions
                if (nums[k] > 0) break;
                //优化：遇到重复数值直接跳到下一位，减少循环遍历
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                int left = k + 1;
                int right = nums.length - 1;
                // [-1,0,1,2,-1,-4] -4 -1 -1 0 1 2
                while (left < right) {
                    //固定k，查看左右指针往哪边移动
                    if (nums[left] + nums[right] < -nums[k]) {
                        left++;
                    } else if (nums[left] + nums[right] > -nums[k]) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[k], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                }
            }
            return new ArrayList<>(result);
        }

        public List<List<Integer>> threeSumBrute(int[] nums) {
            //边界
            if (nums == null || nums.length <= 2) {
                return Collections.emptyList();
            }
            Arrays.sort(nums);
            Set<List<Integer>> result = new HashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }
    }
}
