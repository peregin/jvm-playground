package study.alg.search;

public class Power {

    public int pow(int x, int n, int d) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        int pow = pow(x, n/2, d);

        long res = pow;
        res = (res * pow) % d; // to kick in the long
        if (n % 2 > 0) res = (x * res) % d;

        res = res % d;
        if (res < 0) res += d;

        return (int) res;
    }

    public int pow1(int x, int n, int d) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
            res %= d;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Power alg = new Power();
        //int res = alg.pow(2, 3, 2); // 2
        int res = alg.pow(79161127, 99046373, 57263970); // 47168647
        //int res = alg.pow(-1, 1, 20); // 47168647
        System.out.println("res = " + res);
    }
}
