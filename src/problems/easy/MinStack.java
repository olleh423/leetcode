package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 26-10-2020
 */
public class MinStack {

    public static void main(String[] args) {

        MinStack obj = new MinStack();
    }

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
        int min = minStack.isEmpty() ? x : x < minStack.peek() ? x : minStack.peek();
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}