package study.alg.trees;

import java.util.ArrayList;
import java.util.Stack;

public class Traversal {

    // no recursion
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = A;
        while (true) {
            while(n != null) {
                stack.push(n);
                n = n.left;
            }
            if (stack.isEmpty()) {
                return list;
            }
            n = stack.pop();
            list.add(n.val);
            n = n.right;
        }
    }

    // no recursion
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        TreeNode n = A;
        stack.push(n);
        while (!stack.isEmpty()) {

            TreeNode tn = stack.pop();
            temp.push(tn);

            if (tn.left != null) stack.push(tn.left);
            if (tn.right != null) stack.push(tn.right);
        }

        while (!temp.isEmpty()) list.add(temp.pop().val);
        return list;
    }

    // no recursion
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = A;
        while (true) {
            while(n != null) {
                list.add(n.val);
                stack.push(n);
                n = n.left;
            }
            if (stack.isEmpty()) {
                return list;
            }
            n = stack.pop();
            n = n.right;
        }
    }

    public static void main(String[] args) {
        Traversal alg = new Traversal();
        ArrayList<Integer> res = alg.preorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));
        System.out.println("res is = " + res);
    }
}
