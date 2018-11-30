package study.alg.trees;

public class Depth {

    int maxDepth(TreeNode A, int d) {
        if (A == null) return d;
        return Math.max(maxDepth(A.left, d+1), maxDepth(A.right, d+1));
    }

    public int maxDepth(TreeNode A) {
        return maxDepth(A, 0);
    }


    public int minDepth(TreeNode A) {
        if (A == null) {
            return 0;
        } else if (A.left == null && A.right == null) {
            return 1;
        } else if(A.left == null && A.right != null){
            return 1+minDepth(A.right);
        }
        else if(A.left != null && A.right == null){
            return 1+minDepth(A.left);
        }
        return Math.min(minDepth(A.left), minDepth(A.right)) + 1;
    }

    public static void main(String[] args) {
        Depth alg = new Depth();
        int res = alg.minDepth(new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4))));
        System.out.println("res = " + res);
    }
}
