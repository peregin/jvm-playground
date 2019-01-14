package study.alg.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxHisto {

    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while (i < A.size()) {
            if (stack.isEmpty() || A.get(stack.peek()).compareTo(A.get(i)) < 0) {
                stack.push(i++);
            } else {
                int ix = stack.pop();
                int bar = A.get(ix);
                int weight = stack.empty() ? i : i - stack.peek() - 1;
                max = Math.max(max, bar * weight);
            }
        }

        while (!stack.empty()) {
            int ix = stack.pop();
            int bar = A.get(ix);
            int weight = stack.empty()? i : i - stack.peek() - 1;
            max = Math.max(max, bar * weight);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxHisto alg = new MaxHisto();
        int res = alg.largestRectangleArea(new ArrayList(Arrays.asList(2, 1, 5, 6, 2, 3)));
        System.out.println("res = " + res);
    }
}
