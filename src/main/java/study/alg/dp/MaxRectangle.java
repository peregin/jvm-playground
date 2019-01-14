package study.alg.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxRectangle {

    public int maximalRectangle1(ArrayList<ArrayList<Integer>> A) {
        int x = A.get(0).size()+1;
        int y = A.size()+1;
        int[][] mat = new int[y][x];
        int max = 0;
        for (int j=1; j<y; j++) {
            for (int i=1; i<x; i++) {
                int v = A.get(j-1).get(i-1);
                if (v > 0) {
                    mat[j][i] = Math.min(Math.min(mat[j - 1][i], mat[j][i - 1]), mat[j-1][i-1]) + 1;
                    max = Math.max(max, mat[j][i]);
                } else {
                    mat[j][i] = 0;
                }
            }
        }
        return max * max; // this is max square
    }

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

    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int max = 0;
        int x = A.get(0).size();
        int y = A.size();
        ArrayList<Integer> accu = new ArrayList();
        for (int i = 0; i < x; i++) {
            accu.add(0);
        }
        for (int j=0; j<y; j++) {
            for (int i=0; i<x; i++) {
                if (A.get(j).get(i) == 0) {
                    accu.set(i, 0);
                } else {
                    int v = accu.get(i);
                    accu.set(i, v+1);
                }
            }
            max = Math.max(max, largestRectangleArea(accu));
        }
        return max;
    }

    public static void main(String[] args) {
        MaxRectangle alg = new MaxRectangle();
        int res = alg.maximalRectangle(new ArrayList(Arrays.asList(
                new ArrayList(Arrays.asList(1, 1, 1)),
                new ArrayList(Arrays.asList(0, 1, 1)),
                new ArrayList(Arrays.asList(1, 0, 0))
        )));
        System.out.println("res = " + res);
    }
}
