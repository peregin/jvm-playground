package study.alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Wave {

    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>(A);
        Collections.sort(list);
        for (int i = 0; i < list.size()-1; i += 2) {
            int tmp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, tmp);
        }
        return list;
    }

    public static void main(String[] args) {
        Wave alg = new Wave();
        //ArrayList res = alg.wave(new ArrayList(Arrays.asList(2, 1, 4, 3)));
        ArrayList res = alg.wave(new ArrayList(Arrays.asList(5, 1, 3, 2, 4)));
        System.out.println("res = " + res);
    }
}
