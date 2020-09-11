package leetcode.editor.en.topk;

import java.util.PriorityQueue;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-11 22:43
 */
public class SlidingWindowMaximumA {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        // num of windows
        int[] result = new int[n - k + 1];


        /**
         * PriorityQueue是一个基于优先级堆的无界优先级队列。
         * 优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。
         * 优先级队列不允许使用 null 元素。依靠自然顺序的优先级队列还不允许插入不可比较的对象（这样做可能导致 ClassCastException）。
         *
         * 自然顺序：如果是基本类型，比较数值，从小到大；如果是对象，比较哈希值，从小到大。
         *
         * 改写为大顶堆：
         */
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));

        for (int i = 0; i < n; i++) {

            int start = i - k;
            if (start >= 0){
                maxPQ.remove(nums[start]);
            }
            // insert the element
            maxPQ.offer(nums[i]);

            if (maxPQ.size() == k){
                result[i-k+1] = maxPQ.peek();
            }
        }
        return result;
    }
}
