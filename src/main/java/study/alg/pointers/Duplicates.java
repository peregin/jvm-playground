package study.alg.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Duplicates {

    public static int removeDuplicates1(ArrayList<Integer> a) {
        int i = 0, k = 0;
        int n = a.size();
        if (n < 2) {
            return n;
        }
        while(i < n) {
            if (a.get(i).compareTo(a.get(k)) != 0) {
                a.set(k+1, a.get(i));
                k++;
            }
            i++;
        }
        return k+1;
    }

    // can appear max twice
    public static int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() <= 2)
            return a.size();

        int prev = 1; // point to previous
        int curr = 2; // point to current

        while (curr < a.size()) {
            if (a.get(curr) == a.get(prev) && a.get(curr) == a.get(prev - 1)) {
                curr++;
            } else {
                prev++;
                a.set(prev, a.get(curr));
                curr++;
            }
        }

        System.out.println(a);
        return prev + 1;
    }

    public static void main(String[] args) {
        int res = removeDuplicates(new ArrayList<>(Arrays.asList(1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010)));
        System.out.println("res is "+res);
    }
}
