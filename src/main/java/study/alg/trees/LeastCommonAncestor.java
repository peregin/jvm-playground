package study.alg.trees;

import study.alg.TreeNode;

import java.util.ArrayList;

public class LeastCommonAncestor {

    public int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> listb = find(A, B, new ArrayList<Integer>());
        ArrayList<Integer> listc = find(A, C, new ArrayList<Integer>());
        if (listb.isEmpty() || listc.isEmpty()) {
            return -1;
        }
        int lca = -1;
        for (int i=0; i<listb.size() && i<listc.size(); i++) {
            if (listb.get(i).compareTo(listc.get(i)) != 0) {
                return lca;
            }
            lca = listb.get(i);
        }
        return lca;
    }

    ArrayList<Integer> find(TreeNode node, int n, ArrayList<Integer> path) {
        if (node == null) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> newPath = new ArrayList<Integer>(path);
        newPath.add(node.val);
        if (node.val == n) {
            return newPath;
        }
        ArrayList<Integer> left = find(node.left, n, newPath);
        if (!left.isEmpty()) return left;
        ArrayList<Integer> right = find(node.right, n, newPath);
        if (!right.isEmpty()) return right;

        return new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        LeastCommonAncestor alg = new LeastCommonAncestor();
        //int res = alg.lca(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 2, 3);
        int res = alg.lca(new TreeNode(3, new TreeNode(1), null), 1, 1);
        System.out.println("res = " + res);
    }
}
