package study.alg.linked;

import study.alg.ListNode;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveAllDuplicates {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode n = A;
        HashSet<Integer> dups = new HashSet<>();
        while (n != null) {
            if (n.next != null && n.val == n.next.val) {
                dups.add(n.val);
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }

        //System.out.println("dups = " + dups);
        //A.print(System.out);

        n = A;
        ListNode prev = A;
        while (n != null) {
            if (dups.contains(n.val)) {
                //System.out.println("remove " + n.val);
                if (n == A) {
                    A = n.next; // new head
                } else {
                    prev.next = n.next;
                }
            } else {
                prev = n;
            }
            n = n.next;
        }

        return A;
    }

    public static void main(String[] args) {
        RemoveAllDuplicates alg = new RemoveAllDuplicates();
        ListNode list = alg.deleteDuplicates(ListNode.create(Arrays.asList(1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 4 , 4 , 4 , 4 , 4 , 5 , 5 , 5 , 5 , 6 , 7 , 7 , 7 , 7 , 8 , 8 , 8 , 9 , 9 , 9 , 9 , 9 , 10 , 10 , 10 , 10 , 10 , 10 , 11 , 11 , 11 , 11 , 11 , 11 , 11 , 12 , 12 , 12 , 13 , 13 , 13 , 14 , 14 , 14 , 15 , 15 , 15 , 15 , 15 , 16 , 16 , 16 , 16 , 17 , 18 , 18 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 19 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20 , 20)));
        list.print(System.out);
    }
}
