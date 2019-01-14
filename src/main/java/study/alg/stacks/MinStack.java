package study.alg.stacks;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek().intValue() > x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int i = stack.pop().intValue();
        if (!minStack.isEmpty() && i == minStack.peek().intValue()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek().intValue();
    }

    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek().intValue();
    }

    public static void main(String[] args) {
        MinStack alg = new MinStack();
        alg.push(2);
        alg.push(4);
        int min = alg.getMin();
        System.out.println("res is " + min);
        alg.pop();
        min = alg.getMin();
        System.out.println("res is " + min);
    }
}
