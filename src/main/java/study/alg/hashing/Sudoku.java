package study.alg.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Sudoku {

    // horizontal, vertical lines and the boxes can't contain duplicates
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isValidSudoku(final List<String> A) {
        // check horizontal lines
        for (int i = 0; i < A.size(); i++) {
            if (hasDuplicates(A.get(i))) return 0;
        }
        // check vertical lines
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.size(); i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(A.get(j).charAt(i));
            }
            if (hasDuplicates(sb.toString())) return 0;
            sb.setLength(0);
        }
        // check the boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                for (int x=i; x<i+3; x++) {
                    for (int y=j; y<j+3; y++) {
                        sb.append(A.get(x).charAt(y));
                    }
                }
                if (hasDuplicates(sb.toString())) return 0;
                sb.setLength(0);
            }
        }
        return 1;
    }

    boolean hasDuplicates(String in) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            Character c = in.charAt(i);
            if (Character.isDigit(c)) sb.append(c);
        }
        String s = sb.toString();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return s.length() > set.size();
    }

    public static void main(String[] args) {
        Sudoku alg = new Sudoku();
        List<String> in = Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79");
        //List<String> in = Arrays.asList("..4...63.", ".........", "5......9.", "...56....", "4.3.....1", "...7.....", "...5.....", ".........", ".........");
        in.forEach(System.out::println);
        int res = alg.isValidSudoku(in);
        System.out.println("res = " + res);
    }
}
