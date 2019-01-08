package study.alg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CaptureRegions {

    public void solve(ArrayList<ArrayList<Character>> a) {
        replace(a, 'O', '.');

        // check the boundaries, top
        int width = a.get(0).size();
        int height = a.size();
        for (int i = 0; i< width; i++) {
            fill(a, i, 0, '.', 'O');
        }
        // bottom
        for (int i=0; i<width; i++) {
            fill(a, i, height-1, '.', 'O');
        }
        // left
        for (int i = 0; i< height; i++) {
            fill(a, 0, i, '.', 'O');
        }
        // right
        for (int i = 0; i< height; i++) {
            fill(a, width-1, i, '.', 'O');
        }

        replace(a, '.', 'X');
    }

    void fill(ArrayList<ArrayList<Character>> a, int x, int y, Character what, Character with) {
        if (x < 0 || x >= a.get(0).size()) return;
        if (y < 0 || y >= a.size()) return;

        ArrayList<Character> line = a.get(y);
        Character c = line.get(x);
        if (c != what) return;

        line.set(x, with);
        fill(a, x-1, y, what, with);
        fill(a, x+1, y, what, with);
        fill(a, x, y-1, what, with);
        fill(a, x, y+1, what, with);
    }

    void replace(ArrayList<ArrayList<Character>> a, Character what, Character with) {
        for (int i=0; i<a.size(); i++) {
            ArrayList<Character> line = a.get(i);
            for (int j=0; j<line.size(); j++) {
                if (line.get(j) == what) {
                    line.set(j, with);
                }
            }
        }
    }

    static void print(ArrayList<ArrayList<Character>> a) {
        for(ArrayList<Character> ch: a) {
            System.out.println(ch);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CaptureRegions alg = new CaptureRegions();
//        ArrayList<String> in = new ArrayList(Arrays.asList(
//                "XXXX",
//                "XOOX",
//                "XXOX",
//                "XOXX"
//        ));
        ArrayList<String> in = new ArrayList(Arrays.asList(
                "XOXXXXOOXX",
                "XOOOOXOOXX",
                "OXXOOXXXOO",
                "OXOXOOOXXO",
                "OXOOXXOOXX",
                "OXXXOXXOXO",
                "OOXXXXOXOO"
        ));
        ArrayList<ArrayList<Character>> matrix = in.stream().map(s -> {
            ArrayList<Character> ch = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                ch.add(s.charAt(i));
            }
            return ch;
        }).collect(Collectors.toCollection(() -> new ArrayList<>()));

        print(matrix);
        alg.solve(matrix);
        print(matrix);
    }
}
