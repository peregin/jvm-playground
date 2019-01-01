package study.alg.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColor {

    public void sortColors(ArrayList<Integer> a) {
        int[] colors = new int[3];

        for (Integer i: a) {
            colors[i]++;
        }

        for (int i = 0; i < a.size(); i++) {
            for (int c = 0; c < 3; c++) {
                if (colors[c] > 0) {
                    colors[c]--;
                    a.set(i, c);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortByColor alg = new SortByColor();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 1, 2));
        System.out.println(" in = " + list);
        alg.sortColors(list);
        System.out.println("res = " + list);
    }
}
