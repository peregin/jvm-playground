package study.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciSum {

    // N = 4
    //Fibonacci numbers : 1 1 2 3 5 .... so on
    //here 2 + 2 = 4
    //so minimum numbers will be 2
    public int fibsum(int A) {
        // generate fibonacci numbers until N
        List<Integer> fib = new ArrayList(Arrays.asList(1, 1));
        while(fib.get(fib.size()-1) < A) {
            int next = fib.get(fib.size()-1) + fib.get(fib.size()-2);
            fib.add(next);
        }

        // try for each value from the right
        List<Integer> sum = new ArrayList<>();
        int c = A;
        for (int i=fib.size()-1; i>0; i--) {
            int last = fib.get(i);
            while(A >= last) {
                sum.add(last);
                A -= last;
            }
            if (A == 0) break;
        }
        return sum.size();
    }

    public static void main(String[] args) {
        FibonacciSum alg = new FibonacciSum();
        int res = alg.fibsum(4);
        System.out.println("res = " + res);
    }
}
