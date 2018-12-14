package study.alg.trees;

import study.alg.TreeNode;

public class SumRootToLeafs {

    public int sumNumbers(TreeNode A) {
        return sum(A, 0) % 1003;
    }

    int sum(TreeNode node, int accu) {
        if (node == null) {
            return 0;
        }
        int on = (accu * 10 + node.val) % 1003;
        // if leaf then return the value
        if (node.left == null && node.right == null) {
            return on;
        }

        return sum(node.left, on) + sum(node.right, on);
    }

    public static void main(String[] args) {
        SumRootToLeafs alg = new SumRootToLeafs();
        int res = alg.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
        System.out.println("res = " + res);
    }
}
