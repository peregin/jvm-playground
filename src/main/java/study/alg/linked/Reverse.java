package study.alg.linked;

import study.alg.ListNode;

import java.util.Arrays;

public class Reverse {

    public ListNode reverse(ListNode node) {
        if (node == null) return null;
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Reverse alg = new Reverse();
        ListNode in = ListNode.create(Arrays.asList(1, 5, 4, 3));
        ListNode res = alg.reverse(in);
        res.print(System.out);
    }
}
