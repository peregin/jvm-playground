package study.alg.dp;

public class EditDistance {

    public int minDistance(String A, String B) {
        int na = A.length()+1;
        int nb = B.length()+1;
        int[][] matrix = new int[na][nb];
        for (int i = 0; i < na; i++) {
            for(int j = 0; j < nb; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < na; i++) {
            matrix[i][0] = i;
        }
        for (int i = 0; i < nb; i++) {
            matrix[0][i] = i;
        }

        for (int i = 1; i < na; i++) {
            for(int j = 1; j < nb; j++) {
                int cost = 0;
                if (A.charAt(i-1) != B.charAt(j-1)) {
                    cost = 1;
                }
                int minInsDel = Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1);
                matrix[i][j] = Math.min(minInsDel, matrix[i-1][j-1]+cost);
            }
        }
//        for (int i = 0; i < na; i++) {
//            for(int j = 0; j < nb; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
        return matrix[na-1][nb-1];
    }

    public static void main(String[] args) {
        EditDistance alg = new EditDistance();
        int res = alg.minDistance("Anshuman", "Antihuman");
        System.out.println("res = " + res);
    }
}
