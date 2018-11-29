package study.alg.trees;

import java.io.PrintStream;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this(x, null, null);
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    public void print(PrintStream out) {
        print(out, this);
    }

    // preorder print
    void print(PrintStream out, TreeNode n) {
        if (n == null) {
            return;
        }
        out.println(n.val);
        print(out, n.left);
        print(out, n.right);
    }
}
