package study.alg.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Combinatorics {

    private void permute(ArrayList<Integer> a, int n, int k, ArrayList<ArrayList<Integer>> accu) {
        if (k == 0) {
            ArrayList<Integer> sb = new ArrayList<>();
            for (int i = n; i < a.size(); i++)
                sb.add(a.get(i));
            accu.add(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            Collections.swap(a, i, n - 1);
            permute(a, n - 1, k - 1, accu);
            Collections.swap(a, i, n - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A, int k) {
        ArrayList<ArrayList<Integer>> accu = new ArrayList<>();
        permute(A, A.size(), k, accu);
        return accu;
    }

    private void combine(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int from, int k) {
        if (k == 0) return;
        for (int i = from; i < A.size(); i++) {
            temp.add(A.get(i));
            res.add(new ArrayList<Integer>(temp));
            combine(A, res, temp, i+1, k-1);
            temp.remove(temp.size()-1);
        }
    }

    public ArrayList<ArrayList<Integer>> combine(ArrayList<Integer> A, int k) {
        ArrayList<ArrayList<Integer>> accu = new ArrayList<>();
        combine(A, accu, new ArrayList<Integer>(), 0, k);
        return accu;
    }

    public static void main(String[] args) {
        Combinatorics alg = new Combinatorics();
        ArrayList<ArrayList<Integer>> perm = alg.permute(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), 2);
        perm.forEach(System.out::println);
        System.out.println("----------------");
        ArrayList<ArrayList<Integer>> comb = alg.combine(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), 2);
        comb.forEach(System.out::println);
    }
}
