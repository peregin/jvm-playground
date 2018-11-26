package study.alg.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Duplicates {

    public static int removeDuplicates(ArrayList<Integer> a) {
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
        return k + 1;
    }

    public static void main(String[] args) {
        int res = removeDuplicates(new ArrayList<>(Arrays.asList(3, 3, 5)));
        System.out.println("res is "+res);
    }
}
