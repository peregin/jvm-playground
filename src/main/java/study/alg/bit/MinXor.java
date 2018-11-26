package study.alg.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinXor {

    public static int findMinXor(ArrayList<Integer> A) {
        A.sort(Comparator.comparingInt(c -> c));
        //System.out.println("list is " + A);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<A.size()-1; i++) {
            int xor = A.get(i) ^ A.get(i+1);
            if (xor < min) min = xor;
        }
        return min;
    }

    public static void main(String[] args) {
        int res = findMinXor(new ArrayList<>(Arrays.asList(4, 0, 7, 9)));
        System.out.println("res = " + res);
    }
}
