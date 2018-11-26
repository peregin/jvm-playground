package study.alg.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OneDuplicate {

    public static int repeatedNumber(final List<Integer> a) {
        Set<Integer> set = new HashSet();
        for (Integer i : a) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return -1;
    }

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(3, 4, 1, 4, 1);
        System.out.println("repeated " + repeatedNumber(list));
    }
}
