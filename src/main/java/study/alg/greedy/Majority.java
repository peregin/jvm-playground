package study.alg.greedy;

import java.util.Arrays;
import java.util.List;

public class Majority {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        int f = 0;
        int num = Integer.MIN_VALUE;
        for(int e: A) {
            if (f == 0) {
                num = e;
                f = 1;
            } else if (num == e) {
                f++;
            } else {
                f--;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Majority alg = new Majority();
        int res = alg.majorityElement(Arrays.asList(2, 1, 2));
        System.out.println("res = " + res);
    }
}
