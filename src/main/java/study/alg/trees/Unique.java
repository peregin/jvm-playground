package study.alg.trees;

import study.alg.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Unique {

    public ArrayList<TreeNode> generateTrees(int a) {
        if (a == 0){
            return new ArrayList<TreeNode>();
        }
        return helper(1, a);
    }

    public ArrayList<TreeNode> helper(int m, int n){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(m>n){
            result.add(null);
            return result;
        }

        for(int i=m; i<=n; i++){
            List<TreeNode> ls = helper(m, i-1);
            List<TreeNode> rs = helper(i+1, n);
            for(TreeNode l: ls){
                for(TreeNode r: rs){
                    TreeNode curr = new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    result.add(curr);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Unique alg = new Unique();
        ArrayList<TreeNode> trees = alg.generateTrees(3);
        trees.forEach(t -> t.print(System.out));
    }
}
