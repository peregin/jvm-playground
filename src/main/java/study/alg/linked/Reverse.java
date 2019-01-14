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

    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode node = A;
        ListNode prev = null;
        if (node == null) return null;

        int counter = 1;
        while (node.next != null && counter <= B-1) {
            prev = node;
            node = node.next;
            counter++;
        }
        ListNode headEnd = prev;

        prev = null;
        ListNode curr = node;
        ListNode next = null;
        ListNode tailEnd = null;
        while (curr != null && counter <= C) {
            if (tailEnd == null) tailEnd = curr;

            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            counter++;
        }

        if (headEnd != null) headEnd.next = prev;
        else A = prev;
        tailEnd.next = curr;

        return A;
    }

    public static void main(String[] args) {
        Reverse alg = new Reverse();
        //ListNode res = alg.reverseBetween(ListNode.create(Arrays.asList(1, 2, 3, 4, 5)), 2, 4);
        //ListNode res = alg.reverseBetween(ListNode.create(Arrays.asList(1)), 1, 1);
        ListNode res = alg.reverseBetween(ListNode.create(Arrays.asList(1, 2, 3)), 1, 2);
        res.print(System.out);
    }
}
