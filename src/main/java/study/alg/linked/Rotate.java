package study.alg.linked;

import study.alg.ListNode;

import java.util.Arrays;

public class Rotate {

    // B is from right
    public ListNode rotateRight(ListNode A, int B) {
        ListNode node = A;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        if (size <= 1) {
            return A; // no rotation needed
        }
        ListNode newHead = A;
        ListNode newTail = null;
        B = B % size;
        if (B == 0) {
            return A; // no rotation needed
        }
        int k = size - B;
        while (k > 0) {
            k--;
            newTail = newHead;
            newHead = newHead.next;
        }
        if (newTail != null) {
            newTail.next = null;
        }
        node = newHead;
        while (node.next != null) {
            node = node.next;
        }
        node.next = A;
        return newHead;
    }

    public static void main(String[] args) {
        Rotate alg = new Rotate();
        //ListNode res = alg.rotateRight(ListNode.create(Arrays.asList(23, 57, 65, 90, 56, 69, 77, 52, 71, 74, 15, 25, 41, 17, 76, 95, 58, 38, 29, 68, 4, 89, 55, 99, 13, 92, 98, 62, 36, 59, 54, 48, 53, 12, 11, 6, 2, 35, 46, 39, 20, 27, 44, 78, 82, 67, 91, 64, 97, 43, 84, 83, 70, 73, 79, 88, 16, 1, 96, 66, 80, 72, 10, 19, 100, 33, 75, 3, 81, 24, 22, 87, 63, 9, 7, 40, 8, 34, 101, 60, 28)), 20);
        //ListNode res = alg.rotateRight(ListNode.create(Arrays.asList(1, 2, 3, 4, 5)), 2);
        //ListNode res = alg.rotateRight(ListNode.create(Arrays.asList(1, 2)), 1);
        ListNode res = alg.rotateRight(ListNode.create(Arrays.asList(68, 86, 36, 16, 5, 75)), 90);
        res.print(System.out);
    }
}
