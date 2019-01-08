package study.alg.graph;

import study.alg.UndirectedGraphNode;

import java.util.*;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        UndirectedGraphNode cloneRoot = null;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        // original -> clone
        Map visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            UndirectedGraphNode nClone = new UndirectedGraphNode(n.label);
            visited.put(n, nClone);
            if (cloneRoot == null) cloneRoot = nClone;

            for (UndirectedGraphNode adj: n.neighbors) {
                if (visited.containsKey(adj)) continue;
                queue.add(adj);
            }
        }

        // at this point we need to traverse again and build the neighbors in the cloned nodes
        Set<UndirectedGraphNode> connected = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            UndirectedGraphNode nClone = (UndirectedGraphNode) visited.get(n);
            for (UndirectedGraphNode child: n.neighbors) {
                UndirectedGraphNode childClone = (UndirectedGraphNode) visited.get(child);
                if (!nClone.neighbors.contains(childClone)) nClone.neighbors.add(childClone);
            }
            connected.add(n);

            for (UndirectedGraphNode adj: n.neighbors) {
                if (connected.contains(adj)) continue;
                queue.add(adj);
            }
        }

        return cloneRoot;
    }

    public static void main(String[] args) {
        CloneGraph alg = new CloneGraph();
        UndirectedGraphNode in = new UndirectedGraphNode(1);
        in.neighbors.add(new UndirectedGraphNode(2));
        UndirectedGraphNode res = alg.cloneGraph(in);
        System.out.println("res is " + res);
    }
}
