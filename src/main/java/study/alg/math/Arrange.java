package study.alg.math;

import java.util.ArrayList;
import java.util.Arrays;

public class Arrange {

    /**
     * Store two numbers in one index using tricks.
     * A = B + C * N;  <=>
     *     B = A % N
     *     C = A / N;
     */
    public void arrange(ArrayList<Integer> a) {
        int N = a.size();
        for (int i = 0; i < N; i++) {
            int num = a.get(i);
            int B = num;
            int C = a.get(num);
            if (C >= N) {
                C = a.get(num) % N;
            }
            int encode = B + C * N;
            a.set(i, encode);
        }
        for (int i = 0; i < N; i++) {
            a.set(i, a.get(i) / N);
        }
    }

    public static void main(String[] args) {
        Arrange alg = new Arrange();
        ArrayList in = new ArrayList(Arrays.asList(0, 1));
        System.out.println("before = " + in);
        alg.arrange(in);
        System.out.println("after = " + in);
    }
}
