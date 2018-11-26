package study.alg.arrays;

import java.util.ArrayList;

public class ConcentricArray {

    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = 2*A - 1;
        for (int r = 0; r < n; r++) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                int rn = r >= A ? n - r - 1: r;
                int cn = c >= A ? n - c - 1: c;
                int d = Math.min(rn, cn);
                integers.add(A - d);
            }
            list.add(integers);
        }
        return list;
    }

    public static void main(String... args) {
        ConcentricArray alg = new ConcentricArray();
        ArrayList<ArrayList<Integer>> list = alg.prettyPrint(4);
        list.forEach(System.out::println);
    }
}
