package leetcode.editor.en.topk;

import java.util.Random;

public class KthLargeElementInAnArray {

    //Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element.
//
// Example 1:
//
//
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
//
//
// Example 2:
//
//
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4
//
// Note:
//You may assume k is always valid, 1 ≤ k ≤ array's length.
// Related Topics Divide and Conquer Heap


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 排序
         *
         * @param nums
         * @param k
         * @return
         */
        public int findKthLargest1(int[] nums, int k) {

            //快排
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);

        }

        public int quickSelect(int[] a, int l, int r, int index) {
            Random random = new Random();
            int i = random.nextInt(r - l + 1) + l;
            swap(a, i, r);


            int q = partition(a, l, r);
            if (q == index) {
                return a[q];
            } else {
                return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
            }
        }

        public int partition(int[] a, int l, int r) {
            int x = a[r], i = l - 1;
            for (int j = l; j < r; ++j) {
                if (a[j] <= x) {
                    swap(a, ++i, j);
                }
            }
            swap(a, i + 1, r);
            return i + 1;
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }


        /**
         * 维护动态数据的最大最小值，考虑堆
         * 建立容量为k的最小值堆
         *
         * @param nums
         * @param k
         * @return
         */
        public int findKthLargest2(int[] nums, int k) {

            int[] sortNums = heapSort(nums);
            return nums[sortNums.length-k];

        }

        public int[] heapSort(int[] nums){
            //堆排序
            int n = nums.length;
            buildHeapify(nums, n);
            for (int i = n - 1; i >= 0 ; i--) {
                //把root（最大值）与尾节点交换
                swap(nums,i,0);
                //i代表当前需要排序的节点个数
                heapify(nums,i,0);
            }
            return nums;
        }

        private void heapify(int[] nums, int n, int i) {
            // 节点i < n
            if (i >= n) {
                return;
            }

            int c1 = 2 * i + 1;
            int c2 = 2 * i + 2;
            int max = i;
            if (c1 < n && nums[c1] > nums[i]) {
                max = c1;
            }
            if (c2 < n && nums[c2] > nums[i]) {
                max = c2;
            }
            if (max != i) {
                swap(nums, max, i);
                heapify(nums, n, max);
            }


        }

        public void buildHeapify(int tree[], int n) {
            int lastNode = n - 1;
            int parent = (lastNode - 1) / 2;
            int i;
            for (i = parent; i >= 0; i--) {
                heapify(tree, n, i);
            }
        }
        //leetcode submit region end(Prohibit modification and deletion)
    }

    public static void main(String[] args) {
        KthLargeElementInAnArray.Solution solution = new KthLargeElementInAnArray().new Solution();
        int[] a = {3,2,1,5,6,4};
        int[] ints = solution.heapSort(a);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
//        solution.findKthLargest2(a, 2);
//        System.out.println(solution.findKthLargest2(a, 2));
    }

}
