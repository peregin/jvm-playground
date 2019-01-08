package study.alg.trees;

import study.alg.TreeNode;

public class IsBST {

    public int isValidBST(TreeNode A) {
        return isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int isValidBST(TreeNode node, int min, int max) {
        if (node == null) return 1;
        // BST constraint
        if (node.val <= min) return 0;
        if (node.val >= max) return 0;
        int left = isValidBST(node.left, min, node.val);
        int right = isValidBST(node.right, node.val, max);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        IsBST alg = new IsBST();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, null, new TreeNode(5)), null));
        //TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, null, new TreeNode(5)), null));
        //TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        int res = alg.isValidBST(root);
        System.out.println("res = " + res);
    }
}
