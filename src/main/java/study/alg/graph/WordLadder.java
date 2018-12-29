package study.alg.graph;

import study.alg.GraphNode;

import java.util.*;
import java.util.stream.Collectors;


public class WordLadder {

    int distance(String a, String b) {
        int an = a.length();
        int bn = b.length();
        int n = Math.min(an, bn);
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                d++;
            }
        }
        return d + Math.abs(an - n) + Math.abs(bn - n);
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        ArrayList<ArrayList<String>> ladder = new ArrayList<>();
        if (start.compareTo(end) == 0) {
            ladder.add(new ArrayList(Arrays.asList(start)));
            return ladder;
        }
        HashSet<String> dictS = new HashSet<>(dict);
        Queue<GraphNode<String>> queue = new LinkedList<>();
        queue.add(new GraphNode(start, null));
        HashSet<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            GraphNode<String> cur = ((LinkedList<GraphNode<String>>) queue).pop();
            visited.add(cur.data);

            // end condition
            if (distance(cur.data, end) <= 1) {
                // found it
                ArrayList<String> list = new ArrayList<>();
                list.add(end);
                GraphNode<String> c = cur;
                while (c != null) {
                    list.add(c.data);
                    c = c.parent;
                }
                // is longer than the shortest, noo need to search further
                if (!ladder.isEmpty()) {
                    if (list.size() > ladder.get(0).size()) {
                        return ladder;
                    }
                }

                Collections.reverse(list);
                ladder.add(list);
            }

            // list adjacent words
            List<String> adjacent = dictS.stream().filter(s -> distance(s, cur.data) == 1).collect(Collectors.toList());
            for (String a: adjacent) {
                if (visited.contains(a)) {
                    continue;
                }
                queue.add(new GraphNode(a, cur));
            }
        }
        return ladder;
    }

    /*
    * Return 0 if there is no such transformation sequence.
    * All words have the same length.
    * All words contain only lowercase alphabetic characters.
     */
    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        if (start.compareTo(end) == 0) {
            return 1;
        }
        Queue<GraphNode<String>> queue = new LinkedList<>();
        queue.add(new GraphNode(start, null));
        HashSet<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            GraphNode<String> cur = ((LinkedList<GraphNode<String>>) queue).pop();
            // end condition
            if (distance(cur.data, end) <= 1) {
                // found it
                int len = 1;
                GraphNode c = cur;
                while (c != null) {
                    System.out.println(c.data + " - " + len);
                    c = c.parent;
                    len++;
                }
                return len;
            }

            visited.add(cur.data);

            // list adjacent words
            List<String> adjacent = dictV.stream().filter(s -> distance(s, cur.data) == 1).collect(Collectors.toList());
            for (String a: adjacent) {
                if (visited.contains(a)) {
                    continue;
                }
                queue.add(new GraphNode(a, cur));
            }
        }
        return 0;
    }

    int test(String in) {
        ArrayList<String> list = new ArrayList(Arrays.asList(in.split(" ")));
        String last = list.remove(list.size() - 1);
        String first = list.remove(list.size() - 1);
        return ladderLength(first, last, list);
    }

    ArrayList<ArrayList<String>> test2(String in) {
        ArrayList<String> list = new ArrayList(Arrays.asList(in.split(" ")));
        String last = list.remove(list.size() - 1);
        String first = list.remove(list.size() - 1);
        return findLadders(first, last, list);
    }

    public static void main(String[] args) {
        WordLadder alg = new WordLadder();
        //String in = "bbaba babaa abbaa bbbbb bbbab bbaaa bbbab aaabb babbb bbaaa bbaaa bbbba baabb abaab bbaaa bbbaa baabb abbaa aaaba abaaa abbba aaaab baaaa abaaa abaab aaabb bbaab babbb ababa aaaab bbabb";
        //int res = alg.test(in);
        //int res = alg.ladderLength("hit", "cog", new ArrayList(Arrays.asList("hot","dot","dog","lot","log")));
        //ArrayList<ArrayList<String>> res = alg.findLadders("hit", "cog", new ArrayList(Arrays.asList("hot","dot","dog","lot","log")));
        String in = "baba abba aaba bbbb abaa abab aaab abba abba abba bbba aaab abaa baba baaa bbaa babb";
        ArrayList<ArrayList<String>> res = alg.test2(in);
        System.out.println("res = " + res);
    }
}
