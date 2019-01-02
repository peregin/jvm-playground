package study.alg.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RodCut {

    public int maxPrice1(List<Integer> price, int n) {
        if (n <= 0) {
            return 0;
        }

        // recursive cut
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < price.size(); i++) {
            max = Math.max(max, price.get(i) + maxPrice1(price, n-i-1));
        }
        return max;
    }





    // maximize the revenue (different problem)
    public int maxPrice(List<Integer> price, int n) {
        int val[] = new int[n+1];
        val[0] = 0;

        for (int i = 1; i<=n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val, price.get(j) + val[i - j - 1]);
            }
            val[i] = max_val;
        }

        return val[n];
    }




    // minimize the cutting cost
    public ArrayList<Integer> rodCut1(int A, ArrayList<Integer> B) {
        Result1 result = new Result1(A);
        enumerate(B, B.size(), B.size(), result);
        return result.res;
    }

    class Result1 {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> res = null;
        int length;

        Result1(int length) {
            this.length = length;
        }

        void store(ArrayList<Integer> cuts) {
            int cost = cost1(cuts, 0, length);
            //System.out.println("cost " + cuts + " = " + cost);
            if (res == null || cost < min) {
                res = cuts;
                min = cost;
            } else if (cost == min && res != null) {
                // check lex sorted
                if (lex(cuts, res) < 0) {
                    res = cuts;
                    min = cost;
                }
            }
        }

        int cost1(ArrayList<Integer> cuts, int from, int to) {
            if (cuts == null || cuts.isEmpty()) return 0;

            int price = to - from;
            int at = cuts.get(0);
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            for (int i=1; i<cuts.size(); i++) {
                int v = cuts.get(i);
                if (v < at) left.add(v);
                else right.add(v);
            }
            return price + cost1(left, from, from+at) + cost1(right, from+at, to);
        }
    }

    static void enumerate(ArrayList<Integer> a, int n, int k, Result1 result) {
        if (k == 0) {
            result.store(new ArrayList<>(a));
            return;
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            enumerate(a, n - 1, k - 1, result);
            swap(a, i, n - 1);
        }
    }

    // helper function that swaps a[i] and a[j]
    static void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }





    // minimize the cutting cost
    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {

        Result res = cost(B, 0, A);
        System.out.println("cost="+res.cost);
        return res.cutsSoFar;
    }

    class Result {
        ArrayList<Integer> cutsSoFar = null;
        int cost;

        public Result(ArrayList<Integer> cutsSoFar, int cost) {
            this.cutsSoFar = cutsSoFar;
            this.cost = cost;
        }

        public Result plus(Result that, int price, int cut) {
            ArrayList<Integer> accu = new ArrayList<>(cut);
            accu.addAll(this.cutsSoFar);
            accu.addAll(that.cutsSoFar);
            return new Result(accu, this.cost+that.cost+price);
        }
    }

    int lex(List<Integer> a, List<Integer> b) {
        StringBuilder sb1 = new StringBuilder();
        a.forEach(i -> sb1.append(i));
        StringBuilder sb2 = new StringBuilder();
        b.forEach(i -> sb2.append(i));
        return sb1.toString().compareTo(sb2.toString());
    }

    Result cost(ArrayList<Integer> cuts, int from, int to) {
        if (cuts == null || cuts.isEmpty()) {
            return new Result(new ArrayList<>(), 0);
        }

        int price = to - from;
        Result min = null;
        for (int i = 0; i < cuts.size(); i++) {
            int at = cuts.get(i);
            ArrayList<Integer> left = cuts.stream().filter(ix -> ix < at).collect(Collectors.toCollection(() -> new ArrayList<Integer>()));
            ArrayList<Integer> right = cuts.stream().filter(ix -> ix > at).collect(Collectors.toCollection(() -> new ArrayList<Integer>()));

            Result res1 = cost(left, from, from+at);
            Result res2 = cost(right, from+at, to);

            Result res = res1.plus(res2, price, at);

            //int cost = price + cost(left, from, from+at, accu) + cost(right, from+at, to, accu);
            if (min == null || res.cost < min.cost || (min.cost == res.cost && lex(res.cutsSoFar, min.cutsSoFar) < 0)) {
                min = res;
            }

        }
        return min;
    }


    public static void main(String[] args) {
        RodCut alg = new RodCut();
        ArrayList res = alg.rodCut(6, new ArrayList(Arrays.asList(1, 2, 5)));
        System.out.println("res = " + res);
    }
}
