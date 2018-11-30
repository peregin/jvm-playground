package study.alg.trees;


import java.util.Stack;

public class KSmallest {


    public int kthsmallest(TreeNode A, int B) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode p = A;
        int result = 0;

        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                B--;
                if (B==0) result = t.val;
                p = t.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KSmallest alg = new KSmallest();
        int res = alg.kthsmallest(new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4))), 2);
        System.out.println("res = " + res);
    }
}
