package study.alg;

public class GreatestCommonDivisor {


    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String... args) {
        System.out.println("result is " + gcd(24, 54));
    }
}
