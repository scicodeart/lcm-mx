package leetcode.editor.en.StackAndQueue;

import java.util.LinkedList;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-06-08 17:47
 */
public class SildingWindowMaximumI {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 滑动窗口次数
            int num = nums.length - k + 1;
            // 返回的int数组
            int[] result = new int[num];
            LinkedList<Integer> queue = new LinkedList();

            // 循环，比较形成单调队列
            for (int i = 0; i < nums.length; i++) {
                //如果更大，则去掉队列里更小的值
                while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                    queue.removeLast();
                }


                // 入队列
                queue.addLast(i);

                //滑动窗口的最左边下标
                int left = i - k + 1;

                // 保证队列里数字是滑动窗口里的数字
                if (queue.peekFirst() < left) {
                    queue.removeFirst();
                }


                //下标已经到了可以输出结果的位置
                if (left >= 0) {
                    result[left] = queue.peekFirst();
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        SildingWindowMaximumI.Solution solution = new SildingWindowMaximumI().new Solution();
        int[] nums = new int[]{1, -1};
        int[] ints = solution.maxSlidingWindow(nums, 1);
        System.out.println(ints);

    }
}
