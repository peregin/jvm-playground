package study.alg.trees;

import study.alg.ListNode;
import study.alg.TreeNode;
import study.alg.graph.BSTFromList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum2 {

    int traverse(TreeNode node, int sum, Set<Integer> accu) {
        if (node == null) {
            return 0;
        }
        int l = traverse(node.left, sum, accu);
        if (accu.contains(sum - node.val)) {
            return 1;
        }
        accu.add(node.val);
        int r = traverse(node.right, sum, accu);
        return Math.max(l, r);
    }

    public int t2Sum(TreeNode A, int B) {
        return traverse(A, B, new HashSet<Integer>());
    }

    public static void main(String[] args) {
        Sum2 alg = new Sum2();
        //int res = alg.t2Sum(new TreeNode(11, new TreeNode(9), new TreeNode(20)), 19);
        List<Integer> list = Arrays.asList(11, 13, 2, 16, 1, 7, -1, -1, -1, -1, -1, -1);
        BSTFromList alg1 = new BSTFromList();
        TreeNode root = alg1.sortedListToBST(ListNode.create(list));
        root.print(System.out);
        int res = alg.t2Sum(root, 4);
        System.out.println("res = " + res);
    }
}
