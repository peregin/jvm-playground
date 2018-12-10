package study.alg.trees;

import study.alg.TreeNode;

public class PathSum {

    public int hasPathSum(TreeNode A, int B) {
        return sumToLeaf(A, B, 0);
    }

    int sumToLeaf(TreeNode node, int sum, int accu) {
        if (node == null) {
            return 0;
        }
        accu += node.val;
        if (node.left == null && node.right == null) {
            return sum == accu ? 1 : 0;
        }
        // could be optimized here
        int l = sumToLeaf(node.left, sum, accu);
        int r = sumToLeaf(node.right, sum, accu);
        return Math.max(l, r);
    }

    public static void main(String[] args) {
        PathSum alg = new PathSum();
        int res = alg.hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4))), 4);
        System.out.println("res = " + res);
    }
}
