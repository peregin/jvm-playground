package study.alg.graph;

import java.util.*;

public class ValidPath {

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        LinkedList<Node> nodes = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        nodes.add(new Node(0, 0));

        while (!nodes.isEmpty()) {
            Node n = nodes.pop();
            visited.add(n);
            //System.out.println("trying="+n);

            if (n.x == A && n.y == B) {
                return "YES";
            }

            // generate valid adjacent nodes
            ArrayList<Node> cand = new ArrayList<>();
            for (int x = -1; x <=1; x++) {
                for(int y=-1; y<=1; y++) {
                    if (x == 0 && y == 0) continue;
                    if (n.x + x < 0 || n.x + x >= A+1) continue;
                    if (n.y + y < 0 || n.y + y >= B+1) continue;

                    Node c = new Node(n.x+x, n.y+y);
                    //if (visited.contains(c)) continue;
                    cand.add(c);
                }
            }

            // filter visited and inside a circle
            for (Node c: cand) {
                boolean out = true;
                for (int i = 0; i < C; i++) {
                    if (D == 0 && c.x == E.get(i) && c.y == F.get(i)) {
                        out = false;
                        break;
                    }
                    if (Math.sqrt(Math.pow(c.x - E.get(i), 2) + Math.pow(c.y - F.get(i), 2)) < D) {
                        out = false;
                        break;
                    }
                }
                if (out && !visited.contains(c) && !nodes.contains(c)) {
                    nodes.add(c);
                }
            }

        }

        return "NO";
    }

    public static void main(String[] args) {
        ValidPath alg = new ValidPath();
        //String res = alg.solve(2, 3, 1, 1, new ArrayList(Arrays.asList(2)), new ArrayList<>(Arrays.asList(3))); // YES
        //String res = alg.solve(41, 67, 5, 0, new ArrayList(Arrays.asList(5, 17, 16, 12, 0, 40)), new ArrayList<>(Arrays.asList(5, 52, 61, 61, 25, 31))); // YES
        String res = alg.solve(2, 73, 5, 1, new ArrayList(Arrays.asList(5, 0, 1, 1, 0, 0)), new ArrayList<>(Arrays.asList(5, 58, 68, 52, 13, 35))); // NO
        System.out.println("res = " + res);
    }
}
