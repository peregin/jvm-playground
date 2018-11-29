package study.alg.trees;

public class Invert {

    public TreeNode invertTree(TreeNode A) {
        if (A != null) {
            TreeNode temp = A.left;
            A.left = A.right;
            A.right = temp;
            invertTree(A.left);
            invertTree(A.right);
        }
        return A;
    }

    public static void main(String[] args) {
        Invert alg = new Invert();
        TreeNode res = alg.invertTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
        res.print(System.out);
    }
}
