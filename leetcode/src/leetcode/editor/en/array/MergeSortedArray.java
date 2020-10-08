package leetcode.editor.en.array;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-10-09 00:34
 */
public class MergeSortedArray {

    /**
     * 88. 合并两个有序数组
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // two get pointers for nums1 and nums2
            int p1 = m - 1;
            int p2 = n - 1;
            // set pointer for nums1
            int p = m + n - 1;

            // while there are still elements to compare
            while ((p1 >= 0) && (p2 >= 0))
                // compare two elements from nums1 and nums2
                // and add the largest one in nums1
                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

            // add missing elements from nums2(数据源，起始位置，容器，剩余长度)
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

        }
    }
}
