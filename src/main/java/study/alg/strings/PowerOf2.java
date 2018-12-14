package study.alg.strings;

import java.math.BigInteger;

public class PowerOf2 {

    public int power(String A) {
        if (A.length() == 0) {
            return 0;
        }
        BigInteger n = new BigInteger(A);
        if (n.compareTo(BigInteger.ZERO) == 0 || n.compareTo(BigInteger.ONE) == 0) {
            return 0;
        }
        BigInteger check = n.and(n.add(new BigInteger("-1")));
        boolean pow = check.compareTo(BigInteger.ZERO) == 0;
        if (pow) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        PowerOf2 alg = new PowerOf2();
        int res = alg.power("128");
        System.out.println("res = " + res);
    }
}
