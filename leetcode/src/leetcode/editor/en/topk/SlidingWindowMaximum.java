package leetcode.editor.en.topk;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-10 20:41
 */
public class SlidingWindowMaximum {

    //Given an array nums, there is a sliding window of size k which is moving from
//the very left of the array to the very right. You can only see the k numbers in
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window.
//
// Follow up:
//Could you solve it in linear time?
//
// Example:
//
//
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics Heap Sliding Window


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 方法二：双向队列
         * 直觉
         *
         * 如何优化时间复杂度呢？首先想到的是使用堆，因为在最大堆中 heap[0] 永远是最大的元素。
         * 在大小为 k 的堆中插入一个元素消耗 \log(k)log(k) 时间，
         * 因此算法的时间复杂度为 {O}(N \log(k))O(Nlog(k))。
         *
         * 能否得到只要 {O}(N)O(N) 的算法？
         *
         * 我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。
         *
         * 存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。
         *
         * 算法
         *
         * 算法非常直截了当：
         *
         * 处理前 k 个元素，初始化双向队列。
         *
         * 遍历整个数组。在每一步 :
         *
         * 清理双向队列 :
         *
         *   - 只保留当前滑动窗口中有的元素的索引。
         *
         *   - 移除比当前元素小的所有元素，它们不可能是最大的。
         * 将当前元素添加到双向队列中。
         * 将 deque[0] 添加到输出中。
         * 返回输出数组。
         *
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            //边界条件的判断
            if (nums == null || k <= 0)
                return new int[0];
            int[] res = new int[nums.length - k + 1];
            int index = 0;
            //双端队列，就是两边都可以插入和删除数据的队列，注意这里存储
            //的是元素在数组中的下标，不是元素的值
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < nums.length; i++) {
                //如果队列中队头元素和当前元素位置相差i-k，相当于队头元素要
                //出窗口了，就把队头元素给移除，注意队列中存储
                //的是元素的下标（函数peekFirst()表示的是获取队头的下标，函数
                //pollFirst()表示的是移除队头元素的下标）
                if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                //在添加一个值之前，前面比他小的都要被移除掉，并且还要保证窗口
                //中队列头部元素永远是队列中最大的
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                //当前元素的下标加入到队列的尾部
                deque.addLast(i);
                //当窗口的长度大于等于k个的时候才开始计算（注意这里的i是从0开始的）
                if (i >= k - 1) {
                    //队头元素是队列中最大的，把队列头部的元素加入到数组中
                    res[index++] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
