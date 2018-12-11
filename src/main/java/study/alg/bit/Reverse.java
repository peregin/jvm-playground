package study.alg.bit;

public class Reverse {

    public long reverse(long a) {
        long res = 0;
        for (int i=0; i<32; i++) {
            long low = (long)Math.pow(2, i);
            if ((low & a) > 0) {
                long high = (long)Math.pow(2, 32 - i - 1);
                res += high;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Reverse alg = new Reverse();
        long res = alg.reverse(3);
        System.out.println("bits = "+res);
    }
}
