package study.alg.bit;

import java.util.ArrayList;
import java.util.Arrays;

public class CountPairBits {

    public int cntBits(ArrayList<Integer> A) {
        long mod = 1000000007L;
        int n = A.size();
        long res = 0;

        for (int i = 0; i < 32; i++) {
            // count number of elements with i'th bit set
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((A.get(j).intValue() & (1 << i)) != 0) {
                    count++;
                }
            }
            res += (count * (n - count) * 2);
        }

        return (int)(res % mod);
    }

    public static void main(String[] args) {
        CountPairBits alg = new CountPairBits();
        int res = alg.cntBits(new ArrayList(Arrays.asList(1, 3, 5)));
        System.out.println("res = " + res);
    }
}
