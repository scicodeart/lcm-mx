package leetcode.editor.en.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-12 02:43
 */
public class TopKFrequentElement {
    //Given a non-empty array of integers, return the k most frequent elements.
//
// Example 1:
//
//
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//
//
//
// Example 2:
//
//
//Input: nums = [1], k = 1
//Output: [1]
//
//
// Note:
//
//
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size.
// It's guaranteed that the answer is unique, in other words the set of the top
//k frequent elements is unique.
// You can return the answer in any order.
//
// Related Topics Hash Table Heap


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // 统计每个数字出现的次数
            Map<Integer, Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
            // 定义小根堆，根据数字频率自小到大排序
            Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> counter.get(v1) - counter.get(v2));
            // 遍历数组，维护一个大小为 k 的小根堆：
            // 不足 k 个直接将当前数字加入到堆中；否则判断堆中的最小次数是否小于当前数字的出现次数，若是，则删掉堆中出现次数最少的一个数字，将当前数字加入堆中。
            counter.forEach((num, cnt) -> {
                if (pq.size() < k) {
                    pq.offer(num);
                } else if (counter.get(pq.peek()) < cnt) {
                    pq.poll();
                    pq.offer(num);
                }
            });
            // 构造返回结果
            int[] res = new int[k];
            int idx = 0;
            for (int num: pq) {
                res[idx++] = num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
