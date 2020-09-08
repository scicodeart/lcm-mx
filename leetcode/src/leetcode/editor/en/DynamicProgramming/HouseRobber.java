package leetcode.editor.en.DynamicProgramming;

public class HouseRobber {
//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into
//on the same night.
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4.
//
//
// Example 2:
//
//
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
// Related Topics Dynamic Programming


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 递归式：
         * 选i：OPT(i)max = opt(i-2) + arr[i]
         * 不选i：OPT(i)max = opt(i-1)
         * <p>
         * opt[0] = arr[0]
         * opt[i]max = arr[0] || arr[1]
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            return rec_rob(nums, nums.length - 1);
        }

        /**
         * 递归方法(每个i都需要从头算一遍)
         *
         * @param arr
         * @param i
         * @return
         */
        public int rec_rob(int[] arr, int i) {
            if (i == 0) {
                return arr[0];
            } else if (i == 1) {
                return Math.max(arr[0], arr[1]);
            } else {
                // 选i
                int a = rec_rob(arr, i - 2) + arr[i];
                // 不选i
                int b = rec_rob(arr, i - 1);
                return Math.max(a, b);
            }
        }


        /**
         * 动态规划（可复用的f(i)）
         *
         * @param arr
         * @return
         */
        public int dp_opt(int[] arr) {
            int[] opt = new int[arr.length];
            opt[0] = arr[0];
            opt[1] = Math.max(arr[0], arr[1]);
            for (int j = 2; j < arr.length; j++) {
                // 选i
                int a = opt[j - 2] + arr[j];
                // 不选i
                int b = opt[j - 1];
                opt[j] = Math.max(a, b);
            }
            return opt[arr.length - 1];
        }

    }

    public static void main(String[] args) {
        HouseRobber.Solution solution = new HouseRobber().new Solution();
        int[] nums = {1, 2, 4, 1, 7, 8, 3};
        int rob = solution.dp_opt(nums);
        System.out.println(rob);

    }
//leetcode submit region end(Prohibit modification and deletion)


}
