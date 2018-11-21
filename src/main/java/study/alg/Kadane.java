package study.alg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kadane {

    static int kadane(final List<Integer> A) {
        if (A.stream().allMatch(i -> i <= 0)) {
            return Collections.max(A);
        }
        int current_sum = 0;
        int max_sum = 0;
        for (int x: A) {
            current_sum += x;
            if (current_sum < 0) {
                current_sum = 0;
            }
            if (max_sum < current_sum) {
                max_sum = current_sum;
            }
        }
        return max_sum;
    }

    public static void main(String... args) {
        //int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        List<Integer> arr = Arrays.asList(-500);
        //List<Integer> arr = Arrays.asList(-163, -20);
        int sum = kadane(arr);
        System.out.println("longest is " + sum);
    }
}
