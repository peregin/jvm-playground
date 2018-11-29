package study.alg.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Chocolatier {

    public int nchoc(int A, ArrayList<Integer> B) {
        if (B.isEmpty()) return 0;

        int h = (int) Math.pow(10, 9)+7;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        B.forEach(i -> queue.add(i));
        int res = 0;
        while (A > 0) {
            int top = queue.poll();
            res = (res + (top % h)) % h;
            A--;
            queue.add(top/2);
        }
        return res;
    }

    public static void main(String[] args) {
        Chocolatier chocolatier = new Chocolatier();
        int res = chocolatier.nchoc(3, new ArrayList(Arrays.asList(6, 5)));
        System.out.println("res = " + res);
    }
}
