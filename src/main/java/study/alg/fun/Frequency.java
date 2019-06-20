package study.alg.fun;

import java.util.Optional;
import java.util.stream.*;

public class Frequency {

    static char mostFrequent(String text) {
        Optional<Character> character = text.chars()
                .mapToObj(i -> (char) i)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .max((e1, e2) -> (int) (e1.getValue() - e2.getValue()))
                .map(e -> e.getKey());
        return character.orElse('?');
    }

    public static void main(String[] args) {
        char c = mostFrequent("Most frequent character");
        System.out.println("most frequent character is " + c);
    }
}
