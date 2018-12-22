package study.alg.hashing;

import java.util.*;

public class Equal {

    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // sort lexicographically and take the first
        Comparator<ArrayList<Integer>> arrayListComparator = (o1, o2) -> {
            StringBuilder a = new StringBuilder();
            o1.forEach(a::append);
            StringBuilder b = new StringBuilder();
            o2.forEach(b::append);
            return a.toString().compareTo(b.toString());
        };

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0; i<n-1;i++) {
            for (int j=i+1; j<n;j++) {
                int a = A.get(i);
                int b = A.get(j);
                int sum = a + b;
                ArrayList<Integer> seen = map.get(sum);
                if (seen != null) {
                    if (!seen.contains(i) && !seen.contains(j)) {
                        ArrayList<Integer> part = new ArrayList<>();
                        part.addAll(seen);
                        ArrayList<Integer> match = new ArrayList<>();
                        match.add(i);
                        match.add(j);
                        part.addAll(match);
                        res.add(part);

                        //if (arrayListComparator.compare(match, seen) > 0) {
                            map.put(sum, match);
                       // }
                    }
                } else {
                    map.put(sum, new ArrayList(Arrays.asList(i, j)));
                }
            }
        }
        if (res.isEmpty()) {
            return new ArrayList<Integer>();
        }
        Collections.sort(res, arrayListComparator);
        ArrayList<Integer> list = res.get(0);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Equal alg = new Equal();
        //ArrayList res = alg.equal(new ArrayList(Arrays.asList(3, 4, 7, 1, 2, 9, 8)));
        //ArrayList res = alg.equal(new ArrayList(Arrays.asList(1, 1, 1, 1, 1)));
        //ArrayList res = alg.equal(new ArrayList(Arrays.asList(9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9, 7, 1, 3, 9, 7, 8, 1, 0, 5, 5)));
        ArrayList res = alg.equal(new ArrayList(Arrays.asList(8, 6, 6, 3, 2, 7, 2, 5, 2, 8, 9, 6, 7, 1, 5, 5, 11, 5, 8, 11, 0, 3, 12, 2, 1, 5, 7)));
        System.out.println("res = " + res);
    }
}
