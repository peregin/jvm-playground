package study.alg.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MostWater {

    public int maxArea(ArrayList<Integer> A) {
        int max = 0;
        int left = 0;
        int right = A.size()-1;
        while (left < right) {
            int aLeft = A.get(left);
            int aRight = A.get(right);
            int area = (right-left) * Math.min(aLeft, aRight);
            if (area > max) {
                max = area;
            }
            if (aLeft < aRight) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MostWater alg = new MostWater();
        int res = alg.maxArea(new ArrayList(Arrays.asList(1, 5, 4, 3)));
        System.out.println("res = " + res);
    }
}
