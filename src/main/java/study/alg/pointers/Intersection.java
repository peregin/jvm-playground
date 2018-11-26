package study.alg.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int a = 0, b = 0;
        while(a < A.size() && b < B.size()) {
            int va = A.get(a);
            int vb = B.get(b);
            if (va == vb) {
                list.add(va);
                a++;
                b++;
            } else if (va < vb) {
                a++;
            } else {
                b++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = intersect(
//                Arrays.asList(1, 2, 3, 3, 4, 5, 6),
//                Arrays.asList(3, 3, 5)
                Arrays.asList(1),
                Arrays.asList(1)
        );
        System.out.println(list);
    }
}
