package study.alg.strings;

import java.util.Arrays;
import java.util.HashSet;

public class AmazingSubstrings {

    public int solve(String A) {
        HashSet wowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int n = A.length();
        int res = 0;
        for (int i=0; i<n; i++) {
            if (wowels.contains(A.charAt(i))) {
                res += (n-i);
            }
        }
        return res % 10003;
    }

    public static void main(String[] args) {
        AmazingSubstrings alg = new AmazingSubstrings();
        int res = alg.solve("ABEC");
        System.out.println("res = " + res);
    }
}
