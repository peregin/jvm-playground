package study.alg.heaps;

import java.util.*;

public class DistinctNumbers {

    public ArrayList<Integer> dNums1(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        if (B > n) {
            return res;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(A.get(i));
            if (i >= B) {
                queue.removeFirst();
            }
            //System.out.println("queue is " + queue + " i="+i);
            if (i >= B-1) {
                HashSet<Integer> set = new HashSet<>(queue);
                res.add(set.size());
            }
        }
        return res;
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        if (B > n) {
            return res;
        }
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer item = A.get(i);
            int freq = counter.getOrDefault(item, 0);
            counter.put(item, freq + 1);
            if (i >= B) {
                Integer first = A.get(i-B);
                int oldFreq = counter.getOrDefault(first, 0);
                if (oldFreq <= 1) {
                    counter.remove(first);
                } else {
                    counter.put(first, oldFreq-1);
                }
            }
            //System.out.println("queue is " + queue + " i="+i);
            if (i >= B-1) {
                res.add(counter.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DistinctNumbers alg = new DistinctNumbers();
        ArrayList res = alg.dNums(new ArrayList(Arrays.asList(1, 2, 1, 3, 4, 3)), 3);
        System.out.println("res = " + res);
    }
}
