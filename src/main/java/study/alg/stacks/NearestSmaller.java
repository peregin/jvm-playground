package study.alg.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmaller {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<A.size(); i++) {
            Integer item = A.get(i);
            while (!stack.empty() && stack.peek().compareTo(item) >= 0) {
                stack.pop();
            }

            if (stack.empty()) {
                res.add(-1);
            } else {
                res.add(stack.peek());
            }

            stack.push(item);
        }
        return res;
    }

    public static void main(String[] args) {
        NearestSmaller alg = new NearestSmaller();
        //ArrayList res = alg.prevSmaller(new ArrayList(Arrays.asList(3, 2, 1)));
        //ArrayList res = alg.prevSmaller(new ArrayList(Arrays.asList(4, 5, 2, 10, 8)));
        ArrayList res = alg.prevSmaller(new ArrayList(Arrays.asList(39, 27, 11, 4, 24, 32, 32, 1)));
        System.out.println("res = " + res);
    }
}
