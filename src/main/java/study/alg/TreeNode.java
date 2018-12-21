package study.alg;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this(x, null, null);
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    public void print(PrintStream out) {
        List<Integer> accu = new ArrayList<Integer>();

        printInOrder(this, accu);

        for(int i = 0; i<accu.size();i++) {
            if (i>0) out.print(',');
            out.print(accu.get(i));
        }
        out.println();
    }

    // inorder print
    public void printInOrder(TreeNode n, List<Integer> accu) {
        if (n == null) {
            return;
        }
        printInOrder(n.left, accu);
        accu.add(n.val);
        printInOrder(n.right, accu);
    }

    // preorder print
    public void printPreOrder(TreeNode n, List<Integer> accu) {
        if (n == null) {
            return;
        }
        accu.add(n.val);
        printPreOrder(n.left, accu);
        printPreOrder(n.right, accu);
    }
}
