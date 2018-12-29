package study.alg.math;

// Can only move either down or right at any point in time.
// How many possible unique paths are there?
public class UniquePath {

    public int uniquePaths(int A, int B) {
        if (A == 1 && B == 1) {
            return 1;
        } else if (A == 1) {
            return uniquePaths(A, B-1);
        } else if (B == 1) {
            return uniquePaths(A-1, B);
        } else {
            return uniquePaths(A - 1, B) + uniquePaths(A, B - 1);
        }
    }

    public static void main(String[] args) {
        UniquePath alg = new UniquePath();
        int res = alg.uniquePaths(2, 2);
        System.out.println("res = " + res);
    }
}
