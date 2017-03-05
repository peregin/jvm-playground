package jstudy;

import java.util.Arrays;
import java.util.List;

public class Hoi {

    public static void main(String... args) {
        System.out.println("Hoi");

        List<Integer> list = Arrays.asList(1, 3, 6, 9, 1, 4);
        list.stream().filter((a) -> a % 2 == 0).forEach(System.out::println);
    }
}
