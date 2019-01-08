package study.alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBookings {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int a = 0; int an = arrive.size();
        int d = 0; int dn = depart.size();
        int current = 0;
        while (a < an && d < dn) {
            if (arrive.get(a) < depart.get(d)) {
                current++;
                if (current > K) return false;
                a++;
            } else {
                if (current > 0) current--;
                d++;
            }
        }
        // eventually can be more arrivals and no departures
        if (an-a+current > K) return false;
        return true;
    }

    public static void main(String[] args) {
        HotelBookings alg = new HotelBookings();
        //boolean res = alg.hotel(new ArrayList(Arrays.asList(1, 3, 5)), new ArrayList(Arrays.asList(2, 4, 6, 8)), 1);
        boolean res = alg.hotel(
                new ArrayList(Arrays.asList(13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8)),
                new ArrayList(Arrays.asList(28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53)),
                23);
        System.out.println("res = " + res);
    }
}
