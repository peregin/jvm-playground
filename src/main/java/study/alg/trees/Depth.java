package study.alg.trees;

public class Depth {

    int depth(TreeNode A, int d) {
        if (A == null) return d;
        return Math.max(depth(A.left, d+1), depth(A.right, d+1));
    }

    public int maxDepth(TreeNode A) {
        return depth(A, 0);
    }

    public static void main(String[] args) {
        Depth alg = new Depth();
        int res = alg.maxDepth(new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4))));
        System.out.println("res = " + res);
    }
}
