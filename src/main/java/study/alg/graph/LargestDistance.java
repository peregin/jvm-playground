package study.alg.graph;


import java.util.*;

class GraphNode<T> {

    public final T data;
    public final GraphNode parent;
    public final LinkedList<GraphNode<T>> children = new LinkedList();

    public GraphNode(T data, GraphNode parent) {
        this.data = data;
        this.parent = parent;
        if (parent != null) {
            parent.children.add(this);
        }
    }

    public static final <T extends Integer> GraphNode<Integer> build(ArrayList<T> parents) {
        ArrayList<GraphNode<Integer>> nodes = new ArrayList<>();
        GraphNode<Integer> root = null;
        for (T p: parents) {
            if (p.intValue() == -1) {
                root = new GraphNode(p, null);
                nodes.add(root);
            } else {
                GraphNode<Integer> par = nodes.get(p.intValue());
                GraphNode<Integer> node = new GraphNode<>(p, par);
                nodes.add(node);
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

public class LargestDistance {

    public int solve(ArrayList<Integer> A) {
        if (A.size() <= 1) return 0;
        GraphNode<Integer> root = GraphNode.build(A);
        // calculate the diameter of the graph (directed) or n-ary tree
        return diameter(root) - 1;
    }

    int diameter(GraphNode<Integer> node) {
        if (node == null || node.children.isEmpty()) return 0;

        LinkedList<Integer> heights = new LinkedList<>();
        for (GraphNode<Integer> n: node.children) {
            heights.add(height(n));
        }
        int maxDiam = 0;
        for (GraphNode<Integer> n: node.children) {
            maxDiam = Math.max(maxDiam, diameter(n));
        }
        return Math.max(sumOf2Max(heights)+1, maxDiam);
    }

    int height(GraphNode<Integer> node) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return 1;

        int maxHeight = 0;
        for (GraphNode<Integer> n: node.children) {
            maxHeight = Math.max(maxHeight, height(n));
        }
        return maxHeight+1;
    }

    int sumOf2Max(LinkedList<Integer> list) {
        if (list.size() == 1) return list.get(0);
        ArrayList<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted, (o1, o2) -> o2.compareTo(o1));
        return sorted.get(0)+sorted.get(1);
    }

    public static void main(String[] args) {
        LargestDistance alg = new LargestDistance();
        int res = alg.solve(new ArrayList(Arrays.asList(-1, 0, 0, 0, 3)));
        //int res = alg.solve(new ArrayList(Arrays.asList(-1, 0)));
        System.out.println("res = " + res);
    }
}
