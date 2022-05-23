package leetcode.editor.en.array;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-05-23 16:14
 */
public class MoveZerosII {

    class Solution {
        // 把有数字的全部移到开头，最后再补充结尾0
        public void moveZeroes(int[] nums) {

            int lastNoneZeroAt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[lastNoneZeroAt++] = nums[i];
                }
            }

            for (int i = lastNoneZeroAt; i < nums.length; i++) {
                nums[i] = 0;
            }

        }
    }

    class Solution2 {

        public void moveZeroes(int[] nums) {
            // j 下标记录
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                //交换
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }
        }
    }
}
