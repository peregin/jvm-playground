package study.alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Check {

    ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    public static void main(String[] args) {
        Check alg = new Check();
        ArrayList<ArrayList<Integer>> res = alg.performOps(
                new ArrayList<>(Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
                        new ArrayList<>(Arrays.asList(5, 6, 7, 8)),
                        new ArrayList<>(Arrays.asList(9, 10, 11, 12))
                ))
        );
        System.out.println("res is " + res);
    }
}
