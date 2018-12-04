package study.alg.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords {

    public String reverseWords(String a) {
        List<String> words = Arrays.asList(a.split(" ")).stream().map(s -> s.trim()).collect(Collectors.toList());
        Collections.reverse(words);
        StringBuffer accu = new StringBuffer();
        for(String w: words) {
            if (accu.length() > 0) accu.append(" ");
            accu.append(w);
        }
        return accu.toString();
    }

    public static void main(String[] args) {
        ReverseWords alg = new ReverseWords();
        String res = alg.reverseWords("the sky is blue");
        System.out.println("res = " + res);
    }
}
