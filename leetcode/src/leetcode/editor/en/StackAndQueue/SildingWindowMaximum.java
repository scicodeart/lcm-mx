package leetcode.editor.en.StackAndQueue;

import java.util.LinkedList;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-06-03 17:24
 */
public class SildingWindowMaximum {


    /**
     * 循环遍历 标记窗口里的最大值
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            // 窗口个数
            int[] res = new int[nums.length - k + 1];

            LinkedList<Integer> queue = new LinkedList<>();

            // 遍历数组中元素，right表示滑动窗口右边界
            for (int right = 0; right < nums.length; right++) {
                // 如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
                // 直到，队列为空或当前考察元素小于新的队尾元素

                while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                    queue.removeLast();
                }

                // 存储元素下标
                queue.addLast(right);
                // 计算窗口左侧边界
                int left = right - k +1;
                // 当队首元素的下标小于滑动窗口左侧边界left时
                // 表示队首元素已经不再滑动窗口内，因此将其从队首移除
                if (queue.peekFirst() < left) {
                    queue.removeFirst();
                }

                // 由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时
                // 意味着窗口形成。此时，队首元素就是该窗口内的最大值
                if (right +1 >= k) {
                    res[left] = nums[queue.peekFirst()];
                }
            }
            return res;
        }
    }
}
