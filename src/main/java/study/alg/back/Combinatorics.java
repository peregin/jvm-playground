package study.alg.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Combinatorics {

    private void enumerate(ArrayList<Integer> a, int n, int k, ArrayList<ArrayList<Integer>> accu) {
        if (k == 0) {
            ArrayList<Integer> sb = new ArrayList<>();
            for (int i = n; i < a.size(); i++)
                sb.add(a.get(i));
            accu.add(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            Collections.swap(a, i, n - 1);
            enumerate(a, n - 1, k - 1, accu);
            Collections.swap(a, i, n - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> accu = new ArrayList<>();
        enumerate(A, A.size(), A.size(), accu);
        return accu;
    }

    public static void main(String[] args) {
        Combinatorics alg = new Combinatorics();
        ArrayList<ArrayList<Integer>> list = alg.permute(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        list.forEach(System.out::println);
    }
}
