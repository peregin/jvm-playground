package study.alg.trees;

import study.alg.TreeNode;

/**
 * Symmetric around its center.
 * <pre>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * </pre>
 */
public class Symmetrical {

    public int isSymmetric(TreeNode A) {
        if (A == null) return 1;
        return isSymmetric(A.left, A.right);
    }

    private int isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return 1;
        if (left == null || right == null) return 0;
        if (left.val != right.val) return 0;
        int l = isSymmetric(right.left, left.right);
        // can be optimized here
        int r = isSymmetric(right.right, left.left);
        return Math.min(l, r);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        Symmetrical alg = new Symmetrical();
        int res = alg.isSymmetric(a);
        System.out.println("res = " + res);
    }
}
