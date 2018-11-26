package study.alg.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfArrays {

    // DO NOT MODIFY BOTH THE LISTS
    // O(m+n)
    public static double findMedianSortedArrays1(final List<Integer> a, final List<Integer> b) {
        List<Integer> merged = new ArrayList<>();
        int ai = 0, bi = 0;
        int an = a.size(), bn = b.size();
        int n = an + bn;
        int mid = n / 2;
        // merge the 2 lists only until kth (median)
        while (ai < an && bi < bn && merged.size() <= mid) {
            if (a.get(ai) < b.get(bi)) merged.add(a.get(ai++));
            else merged.add(b.get(bi++));
        }
        // handle the remaining
        while (ai < an && merged.size() <= mid) merged.add(a.get(ai++));
        while (bi < bn && merged.size() <= mid) merged.add(b.get(bi++));

        //System.out.println("n="+n+", mid = "+ mid+", merged is " + merged);
        if (n % 2 == 0) {
            return ((double)(merged.get(mid)+merged.get(mid-1)))/2;
        } else {
            return merged.get(mid);
        }
    }

    // DO NOT MODIFY BOTH THE LISTS
    // O(log(m+n)) // intentionally to recursive
    // 1. find partition1,2 such way the all elem from left part1/2 are less than ritgh part1/2 and the size left1/2 = right/2
    // 2. calc 2 medians of a, b, if med a < med b drop first half a and second half b
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() > b.size()) {
            return findMedianSortedArrays(b, a);
        }

        int an = a.size(), bn = b.size();
        int low = 0;
        int high = an;
        while (low <= high) {
            int partA = (low + high) / 2;
            int partB = (an + bn + 1) / 2 - partA;

            int maxLeftA = (partA == 0) ? Integer.MIN_VALUE : a.get(partA - 1);
            int minRightA = (partA == an) ? Integer.MAX_VALUE : a.get(partA);

            int maxLeftB = (partB == 0) ? Integer.MIN_VALUE : b.get(partB - 1);
            int minRightB = (partB == bn) ? Integer.MAX_VALUE : b.get(partB);

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // found it
                if ((an + bn) % 2 == 0) {
                    return ((double)(Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))) / 2;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = partA - 1;
            } else {
                low = partA + 1;
            }
        }
        return -1; // if not sorted
    }

    public static void main(String[] args) {
        double med = findMedianSortedArrays(
                //Arrays.asList(-50, -41, -40, -19, 5, 21, 28),
                //Arrays.asList(-50, -21, -10)
                //Arrays.asList(1, 4, 5),
                //Arrays.asList(2, 3)
                //Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40),
                //Arrays.asList(-2)
                //Arrays.asList(0, 23),
                //Arrays.asList()
                Arrays.asList(35),
                Arrays.asList(1, 35)
        );
        System.out.println("median is "+med);
    }
}
