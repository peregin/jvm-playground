package study.alg.trees;

import study.alg.TreeNode;

import java.util.ArrayList;

public class Flatten {

    public TreeNode flatten(TreeNode a) {
        ArrayList<TreeNode> accu = new ArrayList<>();
        preorder(a, accu);
        for (int i=0; i< accu.size()-1; i++)  {
            TreeNode curr = accu.get(i);
            TreeNode next = accu.get(i+1);
            curr.left = null;
            curr.right = next;
        }
        // clear the last
        TreeNode last = accu.get(accu.size()-1);
        last.left = null;
        last.right = null;
        return accu.get(0);
    }

    void preorder(TreeNode node, ArrayList<TreeNode> accu) {
        if (node == null) return;
        accu.add(node);
        preorder(node.left, accu);
        preorder(node.right, accu);
    }

    public static void main(String[] args) {
        Flatten alg = new Flatten();
        TreeNode in = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        in.print(System.out);
        TreeNode res = alg.flatten(in);
        while (res != null) {
            System.out.println(res.val);
            res = res.right;
        }
    }
}
