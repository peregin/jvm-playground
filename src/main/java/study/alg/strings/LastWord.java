package study.alg.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LastWord {

    public int lengthOfLastWord(final String A) {
        if (A.trim().length() == 0) {
            return 0;
        }
        List<String> words = Arrays.asList(A.split(" ")).stream().map(s -> s.trim()).collect(Collectors.toList());
        int last = words.size() - 1;
        String w = words.get(last);
        return w.length();
    }

    public static void main(String[] args) {
        LastWord alg = new LastWord();
        int res = alg.lengthOfLastWord("Hello wr");
        System.out.println("res = " + res);

    }
}
