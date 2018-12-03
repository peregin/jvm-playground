package study.alg.greedy;

import java.util.Arrays;
import java.util.List;

public class GasStation {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        for (int i = 0; i < A.size(); i++) {
            int remaining = A.get(i) - B.get(i);

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
                //otherwise, reset start index to be current
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        GasStation alg = new GasStation();
        int res = alg.canCompleteCircuit(Arrays.asList(1, 2), Arrays.asList(2, 1));
        System.out.println("res = " + res);
    }
}
