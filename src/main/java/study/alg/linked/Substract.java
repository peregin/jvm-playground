package study.alg.linked;

import java.util.Arrays;
import java.util.Stack;

// first node val = last node val - first node val
public class Substract {

    public ListNode subtract(ListNode A) {
        // find mid
        Stack<ListNode> st = new Stack();
        ListNode curr = A;
        ListNode dcurr = A; // goes with double speed to reach the end of the list
        while (dcurr != null && dcurr.next != null) {
            st.push(curr);
            curr = curr.next;
            dcurr = dcurr.next.next;
        }
        // check whether odd or even size list to skip or not the current value
        if (dcurr != null) curr = curr.next;

        while (curr != null) {
            ListNode node = st.pop();
            node.val = curr.val - node.val;
            curr = curr.next;
        }
        return A;
    }

    public static void main(String[] args) {
        Substract alg = new Substract();
        ListNode list = alg.subtract(ListNode.create(Arrays.asList(1, 2, 3, 4, 5)));
        while(list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
