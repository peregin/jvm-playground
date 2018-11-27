package study.alg.hashing;

import java.util.*;

public class LongestConsecutiveSequence {

    public int longestConsecutive(final List<Integer> A) {
        HashSet<Integer> set = new HashSet<>(A);

        int res = 0;
        for (int i=0; i<A.size(); i++) {
            // check for start and iterate
            int ai = A.get(i);
            if (!set.contains(ai - 1)) {
                // check for next elements
                int x = ai;
                while (set.contains(x)) {
                    x++;
                }
                if (res < x- ai) {
                    res = x- ai;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence alg = new LongestConsecutiveSequence();
        int res = alg.longestConsecutive(Arrays.asList(100, 4, 200, 1, 3, 2));
        System.out.println("res = "+res);
    }
}
