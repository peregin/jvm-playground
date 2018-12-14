package study.alg.trees;

import study.alg.TreeNode;

import java.util.ArrayList;

public class PathSum {

    // 1./
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


    void collectSumToLeaf(TreeNode node, int sum, int accu, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (node == null) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>(path);
        list.add(node.val);
        accu += node.val;
        if (node.left == null && node.right == null) {
            if (sum == accu) {
                res.add(list);
            }
            return;
        }

        collectSumToLeaf(node.left, sum, accu, list, res);
        collectSumToLeaf(node.right, sum, accu, list, res);
    }

    // 2./ collect path with sum
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        collectSumToLeaf(A, B, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public static void main(String[] args) {
        PathSum alg = new PathSum();
        //int res = alg.hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4))), 4);
        ArrayList<ArrayList<Integer>> res = alg.pathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4))), 3);
        System.out.println("res = " + res);
    }
}
