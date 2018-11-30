package study.alg.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class Inversions {

    // if A[i] > A[j] and i < j
    //O(n2)
    public int countInversions1(ArrayList<Integer> A) {
        int n = A.size();
        int res = 0;
        for(int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (A.get(i) > A.get(j)) res++;
            }
        }
        return res;
    }

    // if A[i] > A[j] and i < j
    public int countInversions(ArrayList<Integer> A) {
        TreeMap<Integer, Integer> map = new TreeMap();
        int n = A.size();
        int res = 0;
        for(int i=0; i<n; i++) {
            int v = A.get(i);
            SortedMap<Integer, Integer> greater = map.tailMap(v);
            res += greater.size();
            map.put(v, v);
        }
        return res;
    }

    public static void main(String[] args) {
        Inversions alg = new Inversions();  // 278 -> 290
        int res = alg.countInversions(new ArrayList(Arrays.asList(84, 2, 37, 3, 67, 82, 19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60))); //2, 4, 1, 3, 5)));
        System.out.println("res " + res);
    }
}
