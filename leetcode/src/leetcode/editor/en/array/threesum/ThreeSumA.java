package leetcode.editor.en.array.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-12 19:45
 */
public class ThreeSumA {

    //Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro.
//
// Notice that the solution set must not contain duplicate triplets.
//
//
// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2:
// Input: nums = []
//Output: []
// Example 3:
// Input: nums = [0]
//Output: []
//
//
// Constraints:
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics Array Two Pointers


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            if (nums.length == 0) return result;
            //排序
            Arrays.sort(nums);
            int i = 0;
            //双指针
            for (i = 0; i < nums.length - 2; i++) {

                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int a = i + 1;
                int b = nums.length - 1;
                while (a < b) {
                    int sum = nums[a] + nums[b] + nums[i];
                    if (sum < 0) {
                        while (a < b && nums[a] == nums[++a]) ;
                    } else if (sum > 0) {
                        while (a < b && nums[b] == nums[--b]) ;
                    } else if (nums[a] + nums[b] == -nums[i]) {
                        result.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[i])));
                        while (a < b && nums[a] == nums[a + 1]) a++;
                        while (a < b && nums[b] == nums[b - 1]) b--;

                    }
                }
            }
            return result;
        }

    }

    public static void main(String[] args) {
        Solution solution = new ThreeSumA().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);

        lists.forEach(a -> {
            for (int i = 0; i < a.size(); i++) {
                System.out.println(a.toString());
            }
        });

    }
//leetcode submit region end(Prohibit modification and deletion)

}
