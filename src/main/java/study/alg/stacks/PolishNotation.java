package study.alg.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PolishNotation {

    // ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    // ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
    public int evalRPN(ArrayList<String> A) {
        Stack<String> stack = new Stack<>();
        for (String a: A) {
            if ("+".equals(a)) {
                int sum = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                stack.push(String.valueOf(sum));
            } else if ("/".equals(a)) {
                int d1 = Integer.parseInt(stack.pop());
                int d2 = Integer.parseInt(stack.pop());
                int div = d2 / d1;
                stack.push(String.valueOf(div));
            } else if ("-".equals(a)) {
                int d1 = Integer.parseInt(stack.pop());
                int d2 = Integer.parseInt(stack.pop());
                int min = d2 - d1;
                stack.push(String.valueOf(min));
            } else if ("*".equals(a)) {
                int sum = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                stack.push(String.valueOf(sum));
            } else {
                stack.push(a);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {
        PolishNotation alg = new PolishNotation();
        int res = alg.evalRPN(new ArrayList(Arrays.asList("2", "1", "+", "3", "*")));
        System.out.println("res = " + res);
    }
}
