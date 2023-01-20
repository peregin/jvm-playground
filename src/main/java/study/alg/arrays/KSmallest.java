package study.alg.arrays;

import java.util.*;

public class KSmallest {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int kthsmallest(final List<Integer> A, int B) {
        ArrayList<Integer> list = new ArrayList<>(A);
        Collections.sort(list);
        //System.out.println(list);
        return list.get(B-1);
    }

    public static void main(String[] args) {
        int res = kthsmallest(Arrays.asList(2, 1, 4, 3, 2), 3);
        System.out.println("res is " + res);
    }
}
