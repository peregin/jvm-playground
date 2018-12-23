package study.alg.trees;

import study.alg.TreeNode;

import java.util.Arrays;
import java.util.List;

public class ArrayToBST {

    public TreeNode sortedArrayToBST(final List<Integer> a) {
        int n = a.size();
        if (n == 0) {
            return null;
        }
        int half = n / 2;
        TreeNode node = new TreeNode(a.get(half));
        node.left = sortedArrayToBST(a.subList(0, half));
        node.right = sortedArrayToBST(a.subList(half+1, n));
        return node;
    }

    public static void main(String[] args) {
        ArrayToBST alg = new ArrayToBST();
        TreeNode res = alg.sortedArrayToBST(Arrays.asList(1, 2, 3));
        res.print(System.out);
    }
}
