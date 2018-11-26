package study.alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SetZeros {

    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int rows = a.size();
        int cols = a.get(0).size();

        // collect weather the row or column needs to be rest

        int[] zcols = new int[cols];
        Arrays.fill(zcols, 0);
        int[] zrows = new int[rows];
        Arrays.fill(zrows, 0);
        for (int r = 0; r <rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (a.get(r).get(c) == 0) {
                    zrows[r] = 1;
                    zcols[c] = 1;
                }
            }
        }
        for (int r = 0; r <rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (zrows[r] == 1 || zcols[c] == 1) {
                    a.get(r).set(c, 0);
                } else {
                    a.get(r).set(c, 1);
                }
            }
        }
    }

    public static void main(String... args) {
        ArrayList list = new ArrayList(Arrays.asList(
                new ArrayList(Arrays.asList(1, 0, 1, 1)),
                new ArrayList(Arrays.asList(1, 1, 1, 1)),
                new ArrayList(Arrays.asList(1, 1, 1, 1))
        ));
        setZeroes(list);
        list.forEach(System.out::println);
    }
}
