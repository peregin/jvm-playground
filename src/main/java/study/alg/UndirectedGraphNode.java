package study.alg;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {

    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(UndirectedGraphNode n: neighbors) {
            if (sb.length() > 0) sb.append(',');
            sb.append(n.toString());
        }
        return label + "[" + sb.toString() + "]";
    }
}
