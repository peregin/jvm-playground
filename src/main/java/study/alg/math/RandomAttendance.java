package study.alg.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomAttendance {

    // out of heap space
    public ArrayList<Integer> solve1(int A, ArrayList<Integer> B) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < A; i++) {
            list.add(i+1);
        }
        Collections.sort(list, (o1, o2) -> {
            String a1 = String.valueOf(o1);
            String a2 = String.valueOf(o2);
            return a1.compareTo(a2);
        });
        ArrayList<Integer> res = new ArrayList<>();
        for(Integer ix: B) {
            int roll = ix - 1;
            res.add(list.get(roll));
        }
        return res;
    }

    // count kth element without building the list
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        if (A < 10) {
            return B;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(Integer kth: B) {
            int count = 0;
            for (int d=1; d<=9; d++) {
                int c = countWithPrefix(A, d);
                //System.out.println("prefix["+d+"]="+c);
                if (kth <= count + c) {
                    // bucket is d, the result should be here
                    System.out.println("bucket " + d + " for " + kth + ", count = " + count);
                    int ix = generatePrefix(d, kth-count);
                    res.add(ix);
                    break;
                }
                count += c;
            }
        }
        return res;
    }

    // from digit
    private int generatePrefix(int d, int ix) {
        System.out.println("prefix for "+d+", ix="+ix);
        int check = 0;
        for (int i=0; i < 1000000000; i++) {
            int pow = (int) Math.pow(10, i);
            if (check + pow >= ix) {
                return d*pow + (ix-check);
            }
            check += pow;
        }
        return 0;
    }

    private int countWithPrefix(int num, int d) {
        int digits = (int) Math.log(num) - 1;
        int check = 0;
        for (int i=0; i<digits; i++) {
            check += Math.pow(10, i);
        }
        int last = (int) Math.pow(10, digits);
        int fromLast = d*last;
        if (num >= fromLast) {
            if (num < fromLast) {
                check += last;
            } else {
                check += (num - fromLast);
                if (num == fromLast) {
                    check += 1;
                }
            }
        }
        System.out.println("check num="+num+", d="+d+", count="+check);
        return check;
    }

    public static void main(String[] args) {
        RandomAttendance alg = new RandomAttendance();
        //ArrayList<Integer> res = alg.solve(20, new ArrayList(Arrays.asList(13))); // 1, 20 , 9
        //ArrayList<Integer> res = alg.solve(20, new ArrayList(Arrays.asList(1, 13, 20))); // 1, 20 , 9
        //ArrayList<Integer> res = alg.solve(10, new ArrayList(Arrays.asList(1, 2, 3)));
        //ArrayList<Integer> res = alg.solve(12, new ArrayList(Arrays.asList(2, 5)));  // 10, 2
        //ArrayList<Integer> res = alg.solve(12, new ArrayList(Arrays.asList(5)));  // 2
        //ArrayList<Integer> res = alg.solve(804289385, new ArrayList(Arrays.asList(73114008, 106058146, 349169024, 424238336, 719885387, 41181723, 596516650, 385352037, 220912978, 546200643, 783368691, 298230675, 436318994, 358935157, 560891156, 736094042, 304089173, 499166352, 35005212, 521595369, 294702568, 118377660, 336465783, 56732146, 278722863, 233665124, 536595298, 468703136, 297224545, 193401033, 511344638, 635723059, 564843685, 321608783, 255672009, 480439687, 628175012, 47899273, 326886845, 44798604, 55195037, 305966150, 608413785, 756898538)));
        int a = 12;
        ArrayList<Integer> in = new ArrayList(Arrays.asList(2, 5));
        ArrayList<Integer> res1 = alg.solve1(a, in);
        ArrayList<Integer> res2 = alg.solve(a, in);

        System.out.println("res1 = " + res1);
        System.out.println("res2 = " + res2);
    }
}
