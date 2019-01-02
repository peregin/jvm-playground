package study.alg.heaps;

import study.alg.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSorted {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        if (a == null || a.isEmpty()) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list: a) {
            if (list == null) continue;
            queue.offer(list);
        }

        ListNode head = null;
        ListNode last = head;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = node;
            } else {
                last.next = node;
            }
            last = node;

            if (node.next != null) queue.offer(node.next);
        }

        return head;
    }

    public static void main(String[] args) {
        MergeKSorted alg = new MergeKSorted();
        ListNode res = alg.mergeKLists(new ArrayList<ListNode>(Arrays.asList(
                ListNode.create(Arrays.asList(1, 10, 20)),
                ListNode.create(Arrays.asList(4, 11, 13)),
                ListNode.create(Arrays.asList(3, 8, 9))
        )));
        res.print(System.out);
    }
}
