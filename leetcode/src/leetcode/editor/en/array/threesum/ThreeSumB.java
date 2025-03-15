package leetcode.editor.en.array.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-26 13:07
 */
public class ThreeSumB {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);
            int s = nums.length;

            for (int i = 0; i < s-2; i++) {
                if (nums[i] > 0) break;
                // 2. skip the same `nums[k]`.
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i+1;
                int right = s-1;

                //如果min小于0，则left+right = -min，则输出
                while (left<right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < 0) {
                        // 先++，再比较值,如果相等，则继续++
                        while ((left < right) && (nums[left] == nums[++left]));
                    }else if (sum > 0){
                        while ((left < right) && (nums[right] == nums[--right]));
                    }else {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        while(left < right && nums[left] == nums[++left]);
                        while(left < right && nums[right] == nums[--right]);
                    }
                }

            }
            return result;

        }
    }
}
