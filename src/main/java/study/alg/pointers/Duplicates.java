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
        if (a.size() <= 2) return a.size();

        int removals = 0;
        int curr = 2; // point to current

        while (curr < a.size()) {
            if (a.get(curr).equals(a.get(curr - 1)) && a.get(curr - 1).equals(a.get(curr - 2))) {
                removals++;
                a.remove(curr);
                //System.out.println("after remove " + a + " curr " + curr + " < size " + a.size());
            } else {
                curr++;
            }
        }

        return removals;
    }

    public static void main(String[] args) {
        //int res = removeDuplicates(new ArrayList<>(Arrays.asList(1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010)));
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3));
        int res = removeDuplicates(in);
        //int res = removeDuplicates(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3)));
        //int res = removeDuplicates(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3)));
        System.out.println("res is "+res);
        System.out.println("arr is "+in);
    }
}
