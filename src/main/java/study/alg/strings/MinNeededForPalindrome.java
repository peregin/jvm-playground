package study.alg.strings;

public class MinNeededForPalindrome {

    public int solve(String A) {
        if (new StringBuilder(A).reverse().toString().compareTo(A) == 0) {
            return 0;
        }
        int n = A.length();
        for (int i = 0; i< n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(A.substring(n-i-1)).reverse();
            //System.out.println(sb);
            sb.append(A);
            String s = sb.toString();
            //System.out.println(s);
            if (sb.reverse().toString().compareTo(s) == 0) {
                return i+1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        MinNeededForPalindrome alg = new MinNeededForPalindrome();
        int needed = alg.solve("cbabc");
        System.out.println("min chars needed = " + needed);
    }
}
