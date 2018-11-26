package study.alg.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(ArrayList<String> A) {
        int min = Integer.MAX_VALUE;
        for(String s: A) {
            min = Math.min(min, s.length());
        }
        StringBuilder prefix = new StringBuilder();
        for (int i=0; i<min; i++) {
            char c = A.get(0).charAt(i);
            boolean nomore = false;
            for (int x=1; x < A.size(); x++) {
                if (A.get(x).charAt(i) != c) {
                    nomore = true;
                    break;
                }
            }
            if (nomore) {
                break;
            } else {
                prefix.append(c);
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(
                "abcdefgh",
                "aefghijk",
                "abcefgh"
        ));
        String prefix = longestCommonPrefix(strings);
        System.out.println("prefix is " + prefix);
    }
}
