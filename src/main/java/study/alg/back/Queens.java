package study.alg.back;

import java.util.ArrayList;

public class Queens {

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> accu = new ArrayList<>();

        // setup an empty board
        ArrayList<String> board = new ArrayList<>();
        for (int i=0; i<a; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<a; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }

        // try with backtracking
        solve(accu, board, 0, a);
        return accu;
    }

    void solve(ArrayList<ArrayList<String>> accu, ArrayList<String> on, int row, int size) {
        ArrayList<String> board = new ArrayList(on);
        if (row == size) {
            accu.add(board);
            return;
        }

        // check
        String line = board.get(row);
        StringBuilder sb = new StringBuilder(line);
        for (int i=0; i<size; i++) {
            sb.replace(i, i+1, "Q");
            board.set(row, sb.toString());

            if (valid(board, size, row, i)) {
                solve(accu, board, row + 1, size);
            }

            // backtrack
            sb.replace(i, i+1, ".");
            board.set(row, sb.toString());
        }
    }

    boolean valid(ArrayList<String> board, int size, int row, int col) {
        // check row
        String line = board.get(row);
        for (int c = 0; c < size; c++) {
            if (c == col) {
                continue;
            }
            if (line.charAt(c) == 'Q') {
                return false;
            }
        }
        // check columns
        for (int r = 0; r < size; r++) {
            if (r == row) {
                continue;
            }
            line = board.get(r);
            if (line.charAt(col) == 'Q') {
                return false;
            }
        }
        // check diagonals
        for (int c = col, r = row; c >= 0 && r >= 0; r--, c--) {
            if (c == col && r == row) {
                continue;
            }
            line = board.get(r);
            char ch = line.charAt(c);
            if (ch == 'Q') {
                return false;
            }
        }
        for (int c = col, r = row; c < size && r < size; r++, c++) {
            if (c == col && r == row) {
                continue;
            }
            line = board.get(r);
            char ch = line.charAt(c);
            if (ch == 'Q') {
                return false;
            }
        }
        // check reverse diagonals
        for (int c = col, r = row; c < size && r >= 0; r--, c++) {
            if (c == col && r == row) {
                continue;
            }
            line = board.get(r);
            if (line.charAt(c) == 'Q') {
                return false;
            }
        }
        for (int c = col, r = row; c >= 0 && r < size; r++, c--) {
            if (c == col && r == row) {
                continue;
            }
            line = board.get(r);
            if (line.charAt(c) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queens alg = new Queens();
        ArrayList<ArrayList<String>> res = alg.solveNQueens(4);
        res.forEach(board -> {
            board.forEach(System.out::println);
            System.out.println();
        });
    }
}
