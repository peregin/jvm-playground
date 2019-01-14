package study.alg.hashing;

import java.util.*;

public class PointsOnStraightLine {

    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        // assume the lengths are equal
        int n = a.size();
        if (n <= 1) return n;

        // slope mapped to indexes
        HashMap<Double, Integer> count = new HashMap<>();
        int max = 0;
        // generate all lines and map it per slope, then count it
        for (int i=0; i<n; i++) {
            int vertical = 0;
            int duplicate = 1;
            for (int j=i+1; j<n; j++) {
                int x1 = a.get(i);
                int y1 = b.get(i);
                int x2 = a.get(j);
                int y2 = b.get(j);
                //System.out.println("("+x1+","+y1+") -> ("+x2+","+y2+")");
                int divisor = x2 - x1;
                int divident = y2 - y1;
                if (divisor == 0 && divident == 0) {
                    duplicate++;
                } else if (divisor == 0) {
                    vertical++;
                } else {
                    double slope = divident == 0 ? 0d : ((double)divident) / (double)divisor;
                    int v = count.getOrDefault(slope, 0);
                    count.put(slope, v+1);
                }
            }
            int res = count.values().stream().mapToInt(o -> o.intValue()).max().orElse(0);
            res = Math.max(res, vertical) + duplicate;
            if (res > max) {
                max = res;
            }
            count.clear();
        }
        return max;
    }

    public int run(String s) {
        String[] arr = s.split(" ");
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i=1; i<arr.length; i+=2) {
            a.add(Integer.parseInt(arr[i]));
            b.add(Integer.parseInt(arr[i+1]));
        }
        return maxPoints(a, b);
    }

    public static void main(String[] args) {
        PointsOnStraightLine alg = new PointsOnStraightLine();
        //int res = alg.maxPoints(new ArrayList(Arrays.asList(1, 1)), new ArrayList(Arrays.asList(2, 2)));
        //int res = alg.maxPoints(new ArrayList(Arrays.asList(0, 1, 2, 3)), new ArrayList(Arrays.asList(0, 1, 2, 3)));
        //int res = alg.run("96 15 12 9 10 -16 3 -15 15 11 -10 -5 20 -3 -15 -11 -8 -8 -3 3 6 15 -14 -16 -18 -6 -8 14 9 -1 -7 -1 -2 3 11 6 20 10 -7 0 14 19 -18 -10 -15 -17 -1 8 7 20 -18 -4 -9 -9 16 10 14 -14 -15 -2 -10 -18 9 7 -5 -12 11 -17 -6 5 -17 -2 -20 15 -2 -5 -16 1 -20 19 -12 -14 -1 18 10 1 -20 -15 19 -18 13 13 -3 -16 -17 1 0 20 -18 7 19 1 -6 -7 -11 7 1 -15 12 -1 7 -3 -13 -11 2 -17 -5 -12 -14 15 -3 15 -11 7 3 19 7 -15 19 10 -14 -14 5 0 -1 -12 -4 4 18 7 -3 -5 -3 1 -11 1 -1 2 16 6 -6 -17 9 14 3 -13 8 -9 14 -5 -1 -18 -17 9 -10 19 19 16 7 3 7 -18 -12 -11 12 -15 20 -3 4 -18 1 13 17 -16 -15 -9 -9 15 8 19 -9 9 -17");
        int res = alg.maxPoints(new ArrayList(Arrays.asList(0, 1, 2)), new ArrayList(Arrays.asList(0, 1, 2)));
        //int res = alg.maxPoints(new ArrayList(Arrays.asList(4, 8, -4)), new ArrayList(Arrays.asList(-4, -4, -4)));
        //int res = alg.maxPoints(new ArrayList(Arrays.asList(1, 1, 1)), new ArrayList(Arrays.asList(0, 3, -1)));
        //int res = alg.maxPoints(new ArrayList(Arrays.asList(1, 1, 1, 1, 1)), new ArrayList(Arrays.asList(1, 1, 1, 1, 1)));
        System.out.println("res = " + res);
    }
}
