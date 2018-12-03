package study.alg.bit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SingleNumber {

    public int singleNumber3(final List<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: A) {
            if (map.containsKey(i)) {
                int freq = map.get(i);
                if (freq >= 2) {
                    map.remove(i);
                } else {
                    map.put(i, freq + 1);
                }
            } else {
                map.put(i, 1);
            }
        }
        return map.keySet().iterator().next();
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: A) {
            if (set.contains(i)) set.remove(i); else set.add(i);
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        SingleNumber alg = new SingleNumber();
        int res = alg.singleNumber(Arrays.asList(1, 2, 2, 3, 1));
        System.out.println("res = " + res);
    }
}
