package leetcode.editor.en.array.threesum;

import java.util.*;

public class ThreeSum {

    //Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics array Two Pointers


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * a + b = -c(target)
         * <p>
         * 思路：
         * 1.暴力
         * 2.hash
         * 3.夹逼：双指针，因为不需要返回下标，可以排序后夹逼
         * 参考：https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {

            Arrays.sort(nums);

            List<List<Integer>> result = new ArrayList<>();

            // k就是target，长度预留两个位置所以是nums.length - 2
            for (int k = 0; k < nums.length - 2; k++) {

                //如果排序后第一个数字>0,则说明不存在=0的组合
                // 1. because of j > i > k.
                if (nums[k] > 0) break;
                // 2. skip the same `nums[k]`.
                if (k > 0 && nums[k] == nums[k - 1]) continue;

                //# 3. double pointer
                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];

                    if(sum < 0){
                        // 当s < 0时，i += 1并跳过所有重复的nums[i]；
                        while(i < j && nums[i] == nums[++i]);
                    } else if (sum > 0) {
                        // 当s > 0时，j -= 1并跳过所有重复的nums[j]；
                        while(i < j && nums[j] == nums[--j]);
                    }else {
                        //当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
                        result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                        while(i < j && nums[i] == nums[++i]);
                        while(i < j && nums[j] == nums[--j]);
                    }
                }
            }
            return result;
        }


        /**
         * o（n^3）
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum1(int[] nums) {
            if (nums == null || nums.length <= 2) {
                return Collections.emptyList();
            }
            Arrays.sort(nums);

            /**
             * 为了去重
             */
            Set<List<Integer>> result = new LinkedHashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                            result.add(value);
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
