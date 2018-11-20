package study.alg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {


    private static void enumerate(int[] a, int n, int k, List<String> accu) {
        if (k == 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = n; i < a.length; i++)
                sb.append(a[i]);
            accu.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            enumerate(a, n-1, k-1, accu);
            swap(a, i, n-1);
        }
    }

    // helper function that swaps a[i] and a[j]
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    static public int solve1(int[] A, int B, int C) {
        List<String> result = new LinkedList();
        enumerate(A, A.length, B, result);
        int counter = 0;
        for(String s: result) {
            System.out.println("   "+s);
            if (Integer.valueOf(s) < C && !s.startsWith("0")) {
                System.out.println(s);
                counter++;
            }
        }
        return counter;
    }

    static public int solve(int[] A, int B, int C) {
        java.util.Set<String> res = new java.util.HashSet<String>();
        java.util.Set<Character> alphabet = new java.util.HashSet<Character>();
        for(int c: A) {
            String s = String.valueOf(c);
            alphabet.add(s.charAt(0));
        }
        long from = (long) Math.pow(10, B - 1);
        if (from == 1) from = 0;
        long to = (long) Math.pow(10, B);

        for (long i = from; i< to; i++) {
            String s = String.valueOf(i);
            if (s.length() != B) {
                continue;
            }
            if (Integer.valueOf(s) >= C) {
                continue;
            }
            boolean valid = true;
            for (int p = 0; p<s.length(); p++) {
                char check = s.charAt(p);
                if (!alphabet.contains(check)) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                continue;
            }

            res.add(s);
            //System.out.println("candidate " + s);
        }
        return res.size();
    }

    public static void main(String args[])
    {
        //int[] in = {0, 1, 2, 5};
        //int r = solve(in, 2, 21);
        int[] in = {0};
        int r = solve(in, 1, 5);
        System.out.println("r = " + r);

    }

}

