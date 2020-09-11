package leetcode.editor.en.topk;

import java.util.Arrays;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-10 20:16
 */
public class GetLeastNumbersByQuickSort {


    /**
     *  一、用快排最最最高效解决 TopK 问题：O(N)O(N)
     * 注意找前 K 大/前 K 小问题不需要对整个数组进行 O(NlogN)O(NlogN) 的排序！
     * 例如本题，直接通过快排切分排好第 K 小的数（下标为 K-1），那么它左边的数就是比它小的另外 K-1 个数啦～
     *
     * 因为我们是要找下标为k的元素，第一次切分的时候需要遍历整个数组 (0 ~ n) 找到了下标是 j 的元素，
     * 假如 k 比 j 小的话，那么我们下次切分只要遍历数组 (0~k-1)的元素就行啦，反之如果 k 比 j 大的话，
     * 那下次切分只要遍历数组 (k+1～n) 的元素就行啦，
     * 总之可以看作每次调用 partition 遍历的元素数目都是上一次遍历的 1/2，
     * 因此时间复杂度是 N + N/2 + N/4 + ... + N/N = 2N, 因此时间复杂度是 O(N).
     *
     *
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 最后一个参数表示我们要找的是下标为k-1的数
            return quickSearch(arr, 0, arr.length - 1, k - 1);
        }

        /**
         * quick sort
         * @param nums
         * @param lo
         * @param hi
         * @param k
         * @return
         */
        private int[] quickSearch(int[] nums, int lo, int hi, int k) {
            // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
            int j = partition(nums, lo, hi);
            if (j == k) {
                return Arrays.copyOf(nums, j + 1);
            }
            // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
            return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
        }

        // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
        private int partition(int[] nums, int lo, int hi) {
            int v = nums[lo];
            int i = lo, j = hi + 1;
            while (true) {
                while (++i <= hi && nums[i] < v);
                while (--j >= lo && nums[j] > v);
                if (i >= j) {
                    break;
                }
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
            nums[lo] = nums[j];
            nums[j] = v;
            return j;
        }
    }
}
