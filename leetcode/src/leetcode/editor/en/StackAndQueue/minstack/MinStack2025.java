package leetcode.editor.en.StackAndQueue.minstack;

import java.util.Stack;

public class MinStack2025 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack2025() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        //更小则压入栈 后进先出
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    //如果pop出去的是最小值，则minstack也需要pop掉
    public void pop() {
        if(stack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
