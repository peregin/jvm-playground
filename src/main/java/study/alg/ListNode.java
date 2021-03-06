package study.alg;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; next = null; }


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

    public void print(PrintStream out) {
        ListNode list = this;
        while(list != null) {
            out.print(list.val);
            if (list.next != null) {
                out.print(" -> ");
            }
            list = list.next;
        }
        out.println();
    }
}
