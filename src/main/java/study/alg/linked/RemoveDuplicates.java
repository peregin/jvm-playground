package study.alg.linked;

import study.alg.ListNode;

import java.util.Arrays;

public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode n = A;
        while (n != null) {
            if (n.next != null && n.val == n.next.val) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        RemoveDuplicates alg = new RemoveDuplicates();
        ListNode list = alg.deleteDuplicates(ListNode.create(Arrays.asList(1, 2, 2, 4, 5, 5)));
        list.print(System.out);
    }
}
