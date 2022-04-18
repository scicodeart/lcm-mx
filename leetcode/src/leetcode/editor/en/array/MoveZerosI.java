package leetcode.editor.en.array;

/**
 * @author Hermione.lai
 * @date 2022/3/10 11:03 AM
 */
public class MoveZerosI {

    class Solution {

        /**
         * 一个指针记录0的位置，一碰到不为0的数字，用第二个指针记录，交换掉
         * @param nums
         */
        public void moveZeroes(int[] nums) {

            int n = nums.length;
            int zeroIndex = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    swap(nums, zeroIndex, i);
                    zeroIndex++;
                }
            }
        }

        private void swap(int[] nums, int zeroIndex, int i) {
            int temp = nums[zeroIndex];
            nums[zeroIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        MoveZerosI.Solution solution = new MoveZerosI().new Solution();
        int[] nums1 = {1,1,0,3,12};
        solution.moveZeroes(nums1);
    }
}
