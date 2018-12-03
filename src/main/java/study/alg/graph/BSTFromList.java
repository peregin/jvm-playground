package study.alg.graph;

import study.alg.ListNode;
import study.alg.TreeNode;

import java.util.Arrays;

public class BSTFromList {

    public TreeNode sortedListToBST(ListNode a) {
        if (a == null) {
            return null;
        }
        if (a.next == null) {
            return new TreeNode(a.val);
        }

        // partition by half
        ListNode h = a;
        ListNode dh = a;
        ListNode prev = h;
        while (dh.next != null && dh.next.next != null) {
            prev = h;
            h = h.next;
            dh = dh.next.next;
        }

        if (h != dh) prev.next = null; // mark as end of list
        TreeNode node = new TreeNode(h.val);
        node.left = h == dh ? null : sortedListToBST(a);
        node.right = sortedListToBST(h.next);

        return node;
    }

    public static void main(String[] args) {
        BSTFromList alg = new BSTFromList();
        //TreeNode treeNode = alg.sortedListToBST(ListNode.create(Arrays.asList(1, 2, 3)));
        TreeNode treeNode = alg.sortedListToBST(ListNode.create(Arrays.asList(1, 2)));
        treeNode.print(System.out);
    }
}
