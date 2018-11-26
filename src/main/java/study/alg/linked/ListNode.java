package study.alg.linked;

import java.util.Collections;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }


    public static ListNode create(List<Integer> list) {
        ListNode node = null;
        Collections.reverse(list);
        for (int i: list) {
            ListNode next = new ListNode(i);
            next.next = node;
            node = next;
        }
        return node;
    }
}
