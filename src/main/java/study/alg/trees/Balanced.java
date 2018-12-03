package study.alg.trees;

import study.alg.TreeNode;

public class Balanced {

    int height(TreeNode A) {
        if (A == null) return 0;
        if (A.left == null && A.right == null) return 1;
        return 1 + Math.max(height(A.left), height(A.right));
    }

    public int isBalanced(TreeNode A) {
        if (A == null) return 1;

        int l = height(A.left);
        int r = height(A.right);

        if (isBalanced(A.left) > 0 && isBalanced(A.right) > 0 && Math.abs(l - r) <= 1) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Balanced alg = new Balanced();
        int res = alg.isBalanced(new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4))));
        System.out.println("res = " + res);
    }
}
