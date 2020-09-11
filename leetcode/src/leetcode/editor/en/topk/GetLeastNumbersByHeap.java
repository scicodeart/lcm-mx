package leetcode.editor.en.topk;

import java.util.PriorityQueue;

/**
 *
 * 剑指 Offer 40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author Lai
 * @version 1.0
 * @date 2020-09-10 20:11
 */
public class GetLeastNumbersByHeap {


    /**
     * O(NlogK)
     */
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {

            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                heap.add(arr[i]);
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = heap.poll();
            }
            return result;
        }
    }
}
