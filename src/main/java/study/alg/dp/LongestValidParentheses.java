package study.alg.dp;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String A) {
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int result = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                stack.push(i);
            } else { // is closing bracket
                stack.pop(); // pop the previous opening bracket

                if (!stack.isEmpty()) {
                    result = Math.max(result, i-stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestValidParentheses alg = new LongestValidParentheses();
        int res = alg.longestValidParentheses(")()())");
        System.out.println("res = " + res);
    }
}
