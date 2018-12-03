package study.alg.math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(new String(a));
            return;
        }
        for (int i = 0; i < n; i++) {
            swap1(a, i, n-1);
            perm2(a, n-1);
            swap1(a, i, n-1);
        }
    }
    // swap the characters at indices i and j
    private static void swap1(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }



    private static void enumerate(int[] a, int n, int k, List<String> accu) {
        if (k == 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = n; i < a.length; i++)
                sb.append(a[i]);
            accu.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            enumerate(a, n - 1, k - 1, accu);
            swap(a, i, n - 1);
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
        for (String s : result) {
            System.out.println("   " + s);
            if (Integer.valueOf(s) < C && !s.startsWith("0")) {
                System.out.println(s);
                counter++;
            }
        }
        return counter;
    }

    static public int solve22(int[] A, int B, int C) {
        java.util.Set<String> res = new java.util.HashSet<String>();
        java.util.Set<Character> alphabet = new java.util.HashSet<Character>();
        for (int c : A) {
            String s = String.valueOf(c);
            alphabet.add(s.charAt(0));
        }
        long from = (long) Math.pow(10, B - 1);
        if (from == 1) from = 0;
        long to = (long) Math.pow(10, B);

        for (long i = from; i < to; i++) {
            String s = String.valueOf(i);
            if (s.length() != B) {
                continue;
            }
            if (Integer.valueOf(s) >= C) {
                continue;
            }
            boolean valid = true;
            for (int p = 0; p < s.length(); p++) {
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

    // Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.
    static public int solve(int[] A, int B, int C) {
        int size = A.length;
        if (size == 0) {
            return 0;
        }
        int cLength = String.valueOf(C).length();
        if (B > cLength) {
            // no solution is possible
            return 0;
        }
        if (B == 1 && cLength > 1) {
            return size;
        }
        if (B < cLength) {
            // all solutions are possible
            if (Arrays.stream(A).anyMatch(i -> i == 0)) {
                return (int) ((size - 1) * Math.pow(size, B - 1));
            } else {
                return (int) Math.pow(size, B);
            }
        }
        int counter = 0;
        // A - digits
        // B - base
        int remainder = 0;
        int num = 0;
        int limit = (int) Math.pow(size, B);
        //System.out.println("checking " + limit);
        int numLength = 0;
        for (int v = 0; v < limit; v++) {
            // convert v to the digits
            remainder = v;
            num = 0;
            numLength = 0;
            for (int b = 0; b < B; b++) {
                int base = (int) Math.pow(size, B - b - 1);
                int base10 = (int) Math.pow(10, B - b - 1);
                int ix = (remainder / base);
                int digit = A[ix] * base10;
                if (digit == 0 && b == 0 && B > 1) {
                    break;
                }
                num += digit;
                if (num > 0) {
                    numLength++;
                }
                if (num >= C) {
                    break;
                }
                remainder %= base;
            }
            //System.out.println(num + " - " + numLength + " -> " + v);
            if (num < C && (numLength == B || B == 1)) {
                //System.out.println(num);
                counter++;
            }
        }
        return counter;
    }

    public static void check(int[] in, int b, int c) {
        int r = solve(in, b, c);
        System.out.println("r = " + r);
    }

    public static void main(String args[]) {
        check(new int[] {0, 1, 2, 5}, 2, 21); // 5
        check(new int[] {0, 1, 2, 5}, 1, 123); // 4
        check(new int[] {0}, 1, 5); // 1
        check(new int[] {0, 1, 5}, 1, 2); // 2
        check(new int[] {0, 1, 2, 3, 4, 5, 7, 8, 9}, 9, 51822); // 0
    }

}

