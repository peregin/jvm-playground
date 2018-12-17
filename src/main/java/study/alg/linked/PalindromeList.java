package study.alg.linked;

import study.alg.ListNode;

import java.util.Arrays;

public class PalindromeList {

    public int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // we are the the middle, check for odd or even
        if (fast != null) {
            slow = slow.next;
        }
        // reverse list

        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode n1 = prev; // reversed end
        ListNode n2 = A;
        while (n1 != null) {
            if (n1.val != n2.val) {
                return 0;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return 1;
    }

    public static void main(String[] args) {
        PalindromeList alg = new PalindromeList();
        int res = alg.lPalin(ListNode.create(Arrays.asList(1, 2, 3, 2, 1)));
        System.out.println("res = " + res);
    }
}
