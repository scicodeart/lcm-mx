package leetcode.editor.en.array.mergesortedarray;

import java.util.Arrays;

public class MergeSortedArray2025 {


    class Solution1 {
        /**
         * 尾部插入另一组，然后排序
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            Arrays.sort(nums1);
        }
    }

    class Solution2 {
        /**
         * 双指针
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = 0, p2 = 0;
            int[] sorted = new int[m + n];
            int cur;
            while (p1 < m || p2 < n) {
                if (p1 == m) {
                    cur = nums2[p2++];
                } else if (p2 == n) {
                    cur = nums1[p1++];
                } else if (nums1[p1] < nums2[p2]) {
                    cur = nums1[p1++];
                } else {
                    cur = nums2[p2++];
                }
                sorted[p1 + p2 - 1] = cur;
            }
            for (int i = 0; i != m + n; ++i) {
                nums1[i] = sorted[i];
            }
        }
    }
}
