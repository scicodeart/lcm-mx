package leetcode.editor.en.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Lai
 * @version 1.0
 * @date 2022-05-31 21:48
 */
public class MinStack {

    /**
     * 队列实现栈
     */
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
