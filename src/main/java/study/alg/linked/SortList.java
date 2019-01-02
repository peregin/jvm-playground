package study.alg.linked;

import study.alg.ListNode;

import java.util.Arrays;

public class SortList {

    public ListNode sortList(ListNode A) {
        // split in 2, then merge the list
        if (A == null || A.next == null) return A;

        // break at the middle
        ListNode slow = A;
        ListNode fast = A;
        ListNode prev = A;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = prev.next;
        prev.next = null;

        ListNode left = sortList(A);
        ListNode right = sortList(half);

        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode fake = new ListNode(0);
        ListNode prev = fake;
        while (left != null && right != null) {
            if (left.val < right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        prev.next = left == null ? right : left;
        return fake.next;
    }

    public static void main(String[] args) {
        SortList alg = new SortList();
        ListNode in = ListNode.create(Arrays.asList(1, 5, 4, 3));
        in.print(System.out);
        ListNode res = alg.sortList(in);
        res.print(System.out);
    }
}
