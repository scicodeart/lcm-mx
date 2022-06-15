package leetcode.editor.en.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-06-07 20:50
 */
public class TrappingRainWater {

    class Solution {

        /**
         * 单调栈的解法
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            int ans = 0;
            Deque<Integer> stack = new LinkedList<>();
            int n = height.length;
            for (int i = 0; i < n; ++i) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peek();
                    int currWidth = i - left - 1;
                    int currHeight = Math.min(height[left], height[i]) - height[top];
                    ans += currWidth * currHeight;
                }
                stack.push(i);
            }
            return ans;
        }
    }

    class SolutionForDoubleIndex {

        /**
         * 双指针
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;

            //记录最大值
            int left_max = height[left];
            int right_max = height[right];

            int sum = 0;

            while (left < right) {
                //指针聚拢，谁高度更小，谁优先算面积
                if (left_max < right_max){

                    if (height[++left] < left_max){
                        sum += left_max - height[left];
                    }else {
                        left_max = height[left];
                    }
                }else {
                    if (height[--right] < right_max){
                        sum += right_max - height[right];
                    }else {
                        right_max = height[right];
                    }
                }

            }
            return sum;
        }
    }

}
