package study.alg.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        List<String> list = A.stream().map(i -> String.valueOf(i)).collect(Collectors.toList());
        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuffer sb = new StringBuffer();
        for(String s: list) {
            sb.append(s);
        }
        // trim leading zeros
        if (sb.charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }

    }

    public static void main(String... args) {
        LargestNumber alg = new LargestNumber();
        //String res = alg.largestNumber(Arrays.asList(3, 30, 34, 5, 9));
        String res = alg.largestNumber(Arrays.asList(0, 0, 0, 0, 0));
        System.out.println("res is " + res);
    }
}
