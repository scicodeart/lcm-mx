package leetcode.editor.en.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-05-31 22:30
 */
public class LargestRectangleInHistogram {


    /**
     * 1. 暴力求解
     * for i - n
     * for j = i - n
     * 最小高度 求得max 不断更新 max-area
     */
    class SolutionByBruteForce {
        public int largestRectangleArea(int[] heights) {

            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                for (int j = i; j < heights.length; j++) {
                    // define a min height
                    int height = Integer.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        height = Math.min(height, heights[k]);
                    }
                    maxArea = Math.max(maxArea, height * (j - i + 1));
                }
            }
            return maxArea;
        }
    }

    /**
     * 2. 暴力2 双指针 从中间往外探索最大值 (关键在于第一层循环 每一个index向外扩展的最大值)
     * left right bound
     * area = height[i] * (right - left)
     * update max-area
     */
    class SolutionByExploreIndex {
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
     * 栈 ----- 没看懂
     */
    class SolutionByStack {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];

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


    public static void main(String[] args) {
        LargestRectangleInHistogram.SolutionByBruteForce solution = new LargestRectangleInHistogram().new SolutionByBruteForce();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int maxArea = solution.largestRectangleArea(heights);
        System.out.println(maxArea);

    }
}
