package study.alg.arrays;

import java.util.*;

/**
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "["+start+","+end+"]";
    }
}

public class Intervals {


    static public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList();
        for (Interval in : intervals) {
            if (in.end < newInterval.start) {
                result.add(in);
            } else if (newInterval.end < in.start) {
                result.add(in);
            } else if (in.end <= newInterval.start || in.start <= newInterval.end) {
                newInterval = new Interval(Math.min(in.start, newInterval.start), Math.max(in.end, newInterval.end));
            }
        }
        result.add(newInterval);
        Collections.sort(result, Comparator.comparingInt(left -> left.start));
        return result;
    }

    public static void main(String... args) {

        ArrayList<Interval> list = new ArrayList(Arrays.asList(new Interval(1, 3), new Interval(6, 9)));
        ArrayList<Interval> result = insert(list, new Interval(2, 5));
        result.forEach(in -> System.out.println(in));
    }
}
