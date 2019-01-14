package study.alg.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsets2 {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>()); // empty as per the requirement
        if (A.size() == 0) return res;

        Collections.sort(A);
        generate(A, res, new ArrayList<Integer>(), 0);
        return res;
    }

    void generate(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> accu, int from) {
        for (int i = from; i < A.size(); i++) {
            accu.add(A.get(i));
            if (!res.contains(accu)) res.add(new ArrayList(accu));
            generate(A, res, accu, i+1);
            accu.remove(accu.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets2 alg = new Subsets2();
        ArrayList<ArrayList<Integer>> res = alg.subsetsWithDup(new ArrayList(Arrays.asList(1, 2, 2)));
        System.out.println("res = " + res);
    }
}
