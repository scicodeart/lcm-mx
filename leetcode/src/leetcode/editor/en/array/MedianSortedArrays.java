package leetcode.editor.en.array;

public class MedianSortedArrays {



    //There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)).
//
// You may assume nums1 and nums2 cannot be both empty.
//
// Example 1:
//
//
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
//
//
// Example 2:
//
//
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
//
// Related Topics array Binary Search Divide and Conquer


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {


            int n = nums1.length;
            int m = nums2.length;
            int left = (n + m + 1) / 2;
            int right = (n + m + 2) / 2;
            //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
        }

        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
            if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
            if (len1 == 0) return nums2[start2 + k - 1];

            if (k == 1) return Math.min(nums1[start1], nums2[start2]);

            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;

            if (nums1[i] > nums2[j]) {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            }
            else {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

        MedianSortedArrays.Solution solution = new MedianSortedArrays().new Solution();

        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,5,6};

        solution.findMedianSortedArrays(nums1,nums2);
    }

}
