package study.alg.math;

import java.util.Arrays;
import java.util.List;

public class Hamming {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> A) {
        long ans = 0;
        int n = A.size();
        int mod = 1000000007;

        // traverse over all bits
        for (int i = 0; i < 32; i++) {

            // count number of elements with i'th bit set
            long count = 0;

            for (int j = 0; j < n; j++) {
                if ((A.get(j) & (1 << i)) == 0) {
                    count++;
                }
            }

            // add "count * (n - count) * 2" to the answer
            ans += ((count * (n - count) * 2) % mod);
        }

        return (int)(ans % mod);
    }

    public static void main(String[] args) {
        Hamming alg = new Hamming();
        int res = alg.hammingDistance(Arrays.asList(96, 96, 7, 81, 2, 13));
        System.out.println("res = " + res);
    }
}
