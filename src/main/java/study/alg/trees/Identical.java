package study.alg.trees;

import study.alg.TreeNode;

public class Identical {

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            boolean both = A == null && B == null;
            return both ? 1 : 0;
        }
        if (A.val != B.val) {
            return 0;
        }
        int left = isSameTree(A.left, B.left);
        // optimize here if left == 0 then no need to check right
        int right = isSameTree(A.right, B.right);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        Identical alg = new Identical();
        TreeNode a = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode b = new TreeNode(1, new TreeNode(2), new TreeNode(4));
        int res = alg.isSameTree(a, b);
        System.out.println("res = " + res);
    }
}
