package study.alg;


import java.util.ArrayList;
import java.util.LinkedList;

public class GraphNode<T> {

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
