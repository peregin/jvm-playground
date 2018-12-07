package study.alg.stacks;

import java.util.Stack;

public class RedundantBraces {

    // 0 = no, 1 = yes, has redundant braces
    // (a + (a + b)) no
    // ((a + b) yes
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() == '(') {
                    return 1;
                } else {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        RedundantBraces alg = new RedundantBraces();
        int res = alg.braces("((a + b))");
        //int res = alg.braces("(a + (a + b))");
        System.out.println("res = " + res);
    }
}
