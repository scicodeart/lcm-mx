package leetcode.editor.en.StackAndQueue.largestrectangleinhistogrm;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram2025 {

    /**
     * 1. 暴力求解，循环柱子，循环的时候设置left bound and right bound，找到左右边界，计算面积。
     */
    class SolutionBruteForce {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length;
            if (len == 0) {
                return 0;
            }

            int maxArea = 0;
            for (int i = 0; i < len; i++) {
                int left = i;
                int currentHeight = heights[i];

                // 找左边最后 1 个大于等于 heights[i] 的下标
                while (left > 0 && heights[left - 1] >= currentHeight){
                    left --;
                }

                // 找右边最后 1 个大于等于 heights[i] 的索引
                int right = i;
                while (right < len - 1 && heights[right + 1] >= currentHeight) {
                    right++;
                }
                int width = right - left + 1;
                maxArea = Math.max(maxArea, width * currentHeight);
            }
            return maxArea;
        }
    }

    /**
     * 单调栈原理
     * 1. 栈 ：维护一个栈记录每个i的左边界，因为左边界是探测过的。
     *        用栈存储枚举的最大面积，随着枚举，不断进栈
     */
    class SolutionOn {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];

            /**
             * 找每个i（柱子）的左边界和右边界
             */
            Deque<Integer> mono_stack = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
                mono_stack.push(i);
            }

            mono_stack.clear();
            for (int i = n - 1; i >= 0; --i) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
                mono_stack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }
    }
}
