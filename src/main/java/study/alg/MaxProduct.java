package study.alg;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxProduct {

    static public int maxSpecialProduct1(ArrayList<Integer> A) {
        long mod = 1000000007;
        long max = 0;
        for (int i=0; i<A.size(); i++) {
            int lsv = -1;
            for(int j=0;j<i;j++) {
                if (A.get(j) > A.get(i)) {
                    lsv = j;
                }
            }
            if (lsv <= 0) {
                continue;
            }
            int rsv = -1;
            for(int j=A.size()-1;j>i;j--) {
                if (A.get(j) > A.get(i)) {
                    rsv = j;
                }
            }
            if (rsv <= 0) {
                continue;
            }
            long prod = (lsv % mod * rsv % mod) % mod;
            if (prod > max) {
                //System.out.println("lsv="+lsv+", rsv="+rsv);
                max = prod;
            }
        }
        return (int) (max % mod);
    }

    static public int maxSpecialProduct(ArrayList<Integer> A) {
        long mod = 1000000007;
        long max = 0;
        for (int i=0; i<A.size(); i++) {

            int lsv = -1;
            for(int j=0;j<i;j++) {
                if (A.get(j) > A.get(i)) {
                    lsv = j;
                }
            }
            if (lsv <= 0) {
                continue;
            }
            int rsv = -1;
            for(int j=A.size()-1;j>i;j--) {
                if (A.get(j) > A.get(i)) {
                    rsv = j;
                }
            }
            if (rsv <= 0) {
                continue;
            }
            long prod = (lsv % mod * rsv % mod) % mod;
            if (prod > max) {
                //System.out.println("lsv="+lsv+", rsv="+rsv);
                max = prod;
            }
        }
        return (int) (max % mod);
    }

    public static void main(String... args) {
        //int p = maxSpecialProduct(new ArrayList(Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9))); // 80
        int p = maxSpecialProduct(new ArrayList(Arrays.asList(4, 6, 5, 5, 6, 6, 5, 6, 7, 5, 5, 7, 7))); // 88
        System.out.println("p="+p);
    }
}
