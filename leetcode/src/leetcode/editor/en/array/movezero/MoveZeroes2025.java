package leetcode.editor.en.array.movezero;

public class MoveZeroes2025 {

    class Solution {
        /**
         * [0,1,0,3,12]
         *
         * @param nums
         */
        public int[] moveZeroes(int[] nums) {

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i - count] = nums[i];
                } else {
                    count++;
                }
            }
            if (count != nums.length) {
                if (count > 0) {
                    for (int i = count; i > 0; i--) {
                        nums[nums.length - i] = 0;
                    }
                }
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        MoveZeroes2025 move = new MoveZeroes2025();
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(move.new Solution().moveZeroes(nums));
    }
}
