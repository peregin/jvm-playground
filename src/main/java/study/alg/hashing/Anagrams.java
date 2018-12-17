package study.alg.hashing;

import java.util.*;

public class Anagrams {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();
        for (int i=0; i<A.size(); i++) {
            ArrayList<Integer> part = new ArrayList<>();
            String check = sorted(A.get(i));
            if (seen.contains(check)) {
                continue;
            }
            part.add(i+1);
            for (int j=i+1; j < A.size(); j++) {
                String on = sorted(A.get(j));
                if (on.compareTo(check) == 0) {
                    part.add(j+1);
                    seen.add(on);
                }
            }
            res.add(part);
        }
        return res;
    }

    String sorted(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        Anagrams alg = new Anagrams();
        //ArrayList<ArrayList<Integer>> res = alg.anagrams(Arrays.asList("cat", "dog", "god", "tca"));
        ArrayList<ArrayList<Integer>> res = alg.anagrams(Arrays.asList("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"));
        System.out.println("res = " + res);
    }
}
