package study.alg.fun;

import java.util.Map;
import java.util.stream.*;

public class Frequency {

    static char mostFrequent(String text) {
        Map<Character, Long> char2freq = text.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return char2freq.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> e.getKey())
                .orElse('?');
    }

    public static void main(String[] args) {
        char c = mostFrequent("Most frequent character");
        System.out.println("most frequent character is " + c);
    }
}
